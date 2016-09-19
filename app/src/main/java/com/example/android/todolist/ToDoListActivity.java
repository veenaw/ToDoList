package com.example.android.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        ListView myToDoList = (ListView) findViewById(R.id.myToDoList);
        final EditText myEditText = (EditText) findViewById(R.id.myEditText);

        final ArrayList<String> toDoItems = new ArrayList<String>();

        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                toDoItems);

        //Bind the array adapter to list view
        myToDoList.setAdapter(aa);

        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                Log.v(TAG, "action = "+ event.getAction()+ "keycode  ="+ keyCode);
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        toDoItems.add(0, myEditText.getText().toString());
                        aa.notifyDataSetChanged();
                        myEditText.setText("");
                        return true;
                    }
                return false;
            }
        });

    }
}
