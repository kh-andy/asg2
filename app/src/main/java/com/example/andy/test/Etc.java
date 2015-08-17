package com.example.andy.test;

/**
 * Created by Andy on 2015-08-16.
 */
public class Etc {

    public String year;
    public String geo;
    public String work;
    public String age;
    public String sex;
    public String value;

    public Etc() {
        this.year = " ";
        this.geo = " ";
        this.work = " ";
        this.age = " ";
        this.sex = " ";
        this.value = " ";
    }

    public Etc(String s) {

        String[] arr = s.split(",");
        year = arr[0];
        geo = arr[1];
        work = arr[2];
        age = arr[3];
        sex = arr[4];
        value = arr[7];

    }
}
