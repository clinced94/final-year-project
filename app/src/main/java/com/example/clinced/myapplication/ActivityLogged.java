package com.example.clinced.myapplication;

import java.sql.Date;

/**
 * Created by clinced on 09/11/16.
 */

public class ActivityLogged {

    int id;
    Date date;
    String activity;

    //constructors
    public ActivityLogged() {

    }

    public ActivityLogged(int id, Date date, String activity) {
        this.id = id;
        this.date = date;
        this.activity = activity;
    }


    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }


    //getters
    public int getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public String getActivity() {
        return this.activity;
    }
}
