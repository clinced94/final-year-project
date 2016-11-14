package com.example.clinced.myapplication;

import java.sql.Date;

/**
 * Created by clinced on 09/11/16.
 */

public class ActivityReviewed {

    int id;
    Date date;
    String activity;
    String review;

    //constructors
    public ActivityReviewed() {

    }

    public ActivityReviewed(int id, String activity, String review) {
        this.id = id;
        this.activity = activity;
        this.review = review;
    }

    public ActivityReviewed(int id, Date date, String activity, String review) {
        this.id = id;
        this.date = date;
        this.activity = activity;
        this.review = review;
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

    public void setReview(String review) {
        this.review = review;
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

    public String getReview() {
        return this.review;
    }



}
