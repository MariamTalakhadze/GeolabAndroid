package com.example.recycleview.models;

import android.widget.ImageView;

import java.io.Serializable;

import de.hdodenhof.circleimageview.CircleImageView;

public class Person implements Serializable {
    private String name;
    private String LastName;
    private int Age;
    private String PhoneNumber;
    private int imageurl;

    public Person(String name, String lastName, int age, int imageurl, String PhoneNumber) {
        this.name = name;
        LastName = lastName;
        Age = age;
        this.imageurl = imageurl;
        this.PhoneNumber=PhoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public int getImageurl() {
        return imageurl;
    }

    public int getAge() {
        return Age;
    }

    public String getLastName() {
        return LastName;
    }

    public String getName() {
        return name;
    }
}
