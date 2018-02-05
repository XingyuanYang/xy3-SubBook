package com.example.mac.xy3_subbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by Xingyuan Yang on 2018-02-04.
 * This class is connected to the activity_view.
 * When the user tap the item in the main activity.
 * It will jump to this activity. In this activity
 * we can see the detail of the subscription.
 * More than that, it contains 3 button, back, edit , and delete
 * tap back will return to the main activity without doing anything
 * tap delete will delete current subscription.
 * tap edit will let you write the subscription again for modifying purpose.
 *
 */

public class ViewActivity extends AppCompatActivity {

    private TextView nameText;
    private TextView commentsText;
    private TextView priceText;
    private TextView dateText;
    private BookList bList = new BookList ();
    private Context context;
    private Book book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setContentView (R.layout.activity_view);
        context = getApplicationContext ();
        bList.loadALL (context);

        nameText = (TextView) findViewById(R.id.editName);
        commentsText =  (TextView)findViewById(R.id.editComments);
        priceText = (TextView) findViewById(R.id.editPrice);
        dateText =(TextView) findViewById(R.id.editDate);

        Intent intent = getIntent ();
        final int index = intent.getIntExtra ("info",-1);
        book = bList.getBook (index);
        String name = book.getName ();
        Date date = book.getDate ();
        DateFormat df =  new SimpleDateFormat ("yyyy-MM-dd");
        String date1 = df.format (date);
        Double price = book.getPrice ();
        String price1 = price.toString ();
        String commment = book.getComment ();

        nameText.setText (name);
        dateText.setText (date1);
        priceText.setText (price1);
        commentsText.setText (commment);


        Button returnButton =  findViewById(R.id.btnReturn);
        Button editButton = findViewById (R.id.btnEdit);
        Button deleteButton = findViewById (R.id.btnDelete);



        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnBtn = new Intent(ViewActivity.this,
                        MainActivity.class);

                startActivity(returnBtn);

            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bList.deleteSub (index);
                bList.saveInFile (context);
                Intent returnBtn = new Intent(ViewActivity.this,
                        EditActivity.class);

                startActivity(returnBtn);

            }
        });

        deleteButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                bList.deleteSub (index);
                bList.saveInFile (context);
                Intent returnBtn = new Intent(ViewActivity.this,
                        MainActivity.class);

                startActivity(returnBtn);
            }
        });
    }
}
