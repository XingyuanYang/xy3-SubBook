package com.example.mac.xy3_subbook;

import java.util.Date;

/**
 * Created by Xingyuan Yang on 2018-02-03.
 */

public class Book {

    private String name;
    private Double price;
    private Date date;
    private String comment;

    public Book(String name,Date date, Double price, String Comment){
        this.name = name;
        this.price = 0.0;
        this.comment = comment;
        this.date = new Date();
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getPrice(){return price;}

    public String getComment(){ return  comment;}

    public void setComment(){ this.comment = comment;}

    public Date getDate(){return date;}

    public void setDate(Date date){this.date = date;}


}
