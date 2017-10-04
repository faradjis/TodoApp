package com.codepath.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.*;

public class MainActivity extends AppCompatActivity {
ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        lvitems = (ListView) findViewById(R.id.lvlistitem);
        itemsAdapter = new ArrayAdapter<>(this, layout.simple_list_item_1, items);
        lvitems.setAdapter(itemsAdapter);
        items.add("First item");
        items.add("Second item");
        setupListViewListener();


    }
    public void onAddItem(View n ){
        EditText etNewItem = (EditText) findViewById(R.id.txt_editText);
        String itemText= etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");

    }
    private void setupListViewListener(){
      lvitems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
          @Override
          public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            items.remove(position);
              itemsAdapter.notifyDataSetChanged();




              return true;

          }
      }

      );




    }

}
