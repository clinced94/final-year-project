package com.example.clinced.myapplication;

/**
 * Created by clinced on 09/11/16.
 */

public class Activity {

    int id;
    String name;
    String effect;
    int uses;

    //constructors
    public Activity() {

    }

    public Activity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Activity(int id, String name, String effect) {
        this.id = id;
        this.name = name;
        this.effect = effect;
    }


    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    //getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEffect() {
        return this.effect;
    }

    public int getUses() {
        return this.uses;
    }
}
