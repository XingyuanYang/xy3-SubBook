package com.example.mac.xy3_subbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


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
