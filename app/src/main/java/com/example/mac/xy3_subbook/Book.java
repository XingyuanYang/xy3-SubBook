package com.example.mac.xy3_subbook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Assignment1
 * Created by Xingyuan Yang on 2018-02-03.
 * This is a class about the book, which is the main object in this program
 * It contains name, date, price and comments.
 * Moreover, it will return the name, date,price and comments.
 * and combining those things to a string.
 */

public class Book {

    private String name;
    private Double price;
    private Date date;
    private String comment;

    public Book(String name,Date date, Double price, String comment){
        this.name = name;
        this.price = price;
        this.comment = comment;
        this.date = date;
    }
    public String toString(){
        DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        String rDate = df.format(date);
        return "Name:"+name+ "\nDate:"+rDate + "\nPrice:"+ price + "comments : " + comment ;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getPrice(){return price;}

    public String getComment(){ return  comment;}

    public void setComment(){ this.comment = comment;}

    public Date getDate(){return date;}

    public void setDate(Date date){this.date = date;}


}
