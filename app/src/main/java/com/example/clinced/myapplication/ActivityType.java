package com.example.clinced.myapplication;

/**
 * Created by clinced on 19/11/16.
 */

public class ActivityType {

    int id;
    String activityTypeName;

    public ActivityType() {

    }

    public ActivityType(int id) {
        this.id = id;
    }

    public ActivityType(int id, String activityTypeName) {
        this.id = id;
        this.activityTypeName = activityTypeName;
    }



    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }


    //getters
    public int getId() {
        return this.id;
    }

    public String getActivityTypeName() {
        return this.activityTypeName;
    }





}
