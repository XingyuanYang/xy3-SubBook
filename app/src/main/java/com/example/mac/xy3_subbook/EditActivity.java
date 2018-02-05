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

public class EditActivity extends AppCompatActivity {

    private EditText nameText;
    private EditText commentsText;
    private EditText priceText;
    private EditText dateText;

    private BookList bList = new BookList();
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_edit);
        context = getApplicationContext();

        Button addButton =  findViewById(R.id.btnAdd);

        nameText =  findViewById(R.id.editName);
        commentsText =  findViewById(R.id.editComments);
        priceText =  findViewById(R.id.editPrice);
        dateText = findViewById(R.id.editDate);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bList.loadALL(context);
                setResult(RESULT_OK);
                String name = nameText.getText().toString();
                String  date = dateText.getText ().toString ();
                String price = priceText.getText ().toString ();
                String comments = commentsText.getText().toString();
                Double dprice = new Double(price);
                DateFormat df =  new SimpleDateFormat ("yyyy-MM-dd");
                Date date1 = null;
                try {
                    date1 = df.parse (date);
                } catch (ParseException e) {
                    e.printStackTrace ();
                }

                Book book = new Book(name,date1,dprice,comments);

                bList.addSub (book);
                bList.saveInFile (context);
                Intent returnBtn = new Intent(EditActivity.this,
                        MainActivity.class);

                startActivity(returnBtn);
            }
        });

        returnToMain();
    }

    public void returnToMain(){
        Button btnCancel =  findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnBtn = new Intent(EditActivity.this,
                        MainActivity.class);

                startActivity(returnBtn);
            }
        });

    }

}