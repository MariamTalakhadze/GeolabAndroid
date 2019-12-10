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
    private boolean isChecked = false;

    public Person(String name, String lastName, int age, int imageurl, String PhoneNumber, boolean isChecked) {
        this.name = name;
        LastName = lastName;
        Age = age;
        this.imageurl = imageurl;
        this.PhoneNumber=PhoneNumber;
        this.isChecked = isChecked;
    }
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setName(String name) {
        this.name = name;
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
