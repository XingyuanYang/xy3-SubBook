package com.example.mac.xy3_subbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
/**
 *
 * Created by Xingyuan Yang on 2018-02-04.
 * MainActivity is related to the activity_main.
 * It contains a list that contains all the subscriptions
 * More than that, there is a button add in the bottom.
 * The user can tap the button to add new subscriptions.
 * The user also can tap the item, then they will enter the
 * view activity to see the detail of the subscription.
 * It will load all the information from the list
 * and show up in the list view.
 *
 */


public class MainActivity extends AppCompatActivity {

    private static  final String FILENAME = "file.sav";
    private ListView oldBookList;
    private TextView title;
    private Context context;
    private BookList bList = new BookList ();
    private ArrayAdapter<Book> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext ();

        title = findViewById (R.id.total_subscription);
        Button button1 =  findViewById(R.id.button1);
        oldBookList = findViewById(R.id.List1);
        bList.loadALL (context);
        title.setText (String.format ("SubBook\n"));

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, AddActivity.class);
                startActivity (intent);
            }});

        oldBookList.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent (MainActivity.this, ViewActivity.class);
                intent1.putExtra ("info",position);
                startActivity (intent1);
            }
        });



    }

    @Override
    protected void onStart() {

        super.onStart();
        bList.loadALL (context);
        adapter = new ArrayAdapter<Book> (this,R.layout.support_simple_spinner_dropdown_item,
                bList.getBooklist ());

        oldBookList.setAdapter(adapter);

    }
}
