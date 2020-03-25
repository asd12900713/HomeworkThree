package com.example.HomeworkThree;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class TodoList extends AppCompatActivity {

    private ArrayList<String> list;
    private ArrayAdapter<String> Array_adapter;
    private ListView Listview;
    private EditText EditText;
    private String Selected_item;
    private int number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EditText = (EditText)findViewById(R.id.editText);
        Listview = (ListView)findViewById(R.id.list);
        list = new ArrayList<String>();
        Array_adapter = new ArrayAdapter<String>(
                getApplicationContext(),android.R.layout.simple_list_item_1,list);
        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                number = position;
                Selected_item =(String) adapterView.getItemAtPosition(position);
                EditText.setText(Selected_item);
            }
        });
     /*
        ActionBar actionBar = getSupportActionBar();          //create ActionBar object
        actionBar.setDisplayUseLogoEnabled(true);      //allow logo to be displayed
        actionBar.setDisplayShowHomeEnabled(true);     //allow app icon on Action Bar
        actionBar.setDisplayShowTitleEnabled(false);  //app title not shown
     */
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.todolist_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Uri uri;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ADD:
                String todo_list = EditText.getText().toString();
                list.add(todo_list);
                Listview.setAdapter(Array_adapter);
                Array_adapter.notifyDataSetChanged();
                return true;
            case R.id.update:
                String update_list = EditText.getText().toString();
                list.set(number,update_list);
                Listview.setAdapter(Array_adapter);
                Array_adapter.notifyDataSetChanged();
                return true;
            case R.id.deleted:
                String Remove_item = EditText.getText().toString();
                list.remove(Remove_item);
                Listview.setAdapter(Array_adapter);
                Array_adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

