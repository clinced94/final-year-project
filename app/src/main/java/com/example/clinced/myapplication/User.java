package com.example.clinced.myapplication;

/**
 * Created by clinced on 09/11/16.
 */

public class User {

    int id;
    String name;
    int age;
    int uses_this_month;
    int uses_ever;
    String created_at;


    //constructors
    public User() {

    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(int id, String name, int age, int uses_this_month, int uses_ever) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.uses_this_month = uses_this_month;
        this.uses_ever = uses_ever;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsesThisMonth(int uses_this_month) {
        this.uses_this_month = uses_this_month;
    }

    public void setUses(int uses_ever) {
        this.uses_ever = uses_ever;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    //getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getUsesMonth() {
        return this.uses_this_month;
    }

    public int getUses() {
        return this.uses_ever;
    }
}
