package com.theironyard.contacts_android1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{

    ListView list;
    EditText name;
    EditText phone;
    Button addButton;
    ArrayAdapter<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
        addButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String newName = name.getText().toString();
        String newPhone = phone.getText().toString();
        String contact = (newName + " (" + newPhone + ")");
        items.add(contact);
        name.setText("");
        phone.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }
}
