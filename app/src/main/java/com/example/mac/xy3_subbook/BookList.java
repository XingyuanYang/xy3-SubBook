package com.example.mac.xy3_subbook;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * Created by Xingyuan Yang on 2018-02-04.
 * BookList contain the function of save and load.
 * So, for every activities,it can read data from file
 * and write data into the file. Moreover, we defined the
 * arraylist, which contain all the information of subscriptions.
 *
 */

public class BookList {
    private static  final String FILENAME ="file.sav";
    private ArrayList<Book> booklist;


    public BookList(){this.booklist = new ArrayList<Book>();}

    public ArrayList<Book> getBooklist(){return  this.booklist;}

    public void addSub(Book newbook){
        booklist.add(newbook);
    }

    public void deleteSub(int i){
        booklist.remove(i);
    }

    public Book getBook(int i) {return booklist.get(i);}





    public void loadALL(Context context){
        try{
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
            this.booklist = gson.fromJson(in,listType);

        } catch (FileNotFoundException e){
            this.booklist = new ArrayList<Book>();
        }
    }

    public  void saveInFile(Context context){
        try{
            FileOutputStream fos = context.openFileOutput(FILENAME,context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(this.booklist,out);
            out.flush();
            fos.close();
        }catch (IOException e){
            throw  new RuntimeException();
        }

    }




}
