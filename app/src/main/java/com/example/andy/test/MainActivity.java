package com.example.andy.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Spinner;

import java.io.File;


public class MainActivity extends Activity {

    static String url = "http://www20.statcan.gc.ca/tables-tableaux/cansim/csv/04770028-eng.zip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if csv file exists. If not automatically, download and unzip the file
        File file = new File (Environment.getExternalStorageDirectory().getAbsolutePath(), "/data/04770028-eng.csv");
        if(!file.exists())
            new DLtask(getApplicationContext()).execute(url);

    }

    // Download data asynctask
    public void dlFile(View view) {
        new DLtask(getApplicationContext()).execute(url);
    }

    // Submit form
    public void submit(View view) {
        // Builds a string to use to query the csv file
        // Because of the structure and format of the data within the file, simply building
        // a string that matches a line within the file will return the data we want
        Spinner year = (Spinner)findViewById(R.id.form_year);
        Spinner geo = (Spinner)findViewById(R.id.form_geo);
        Spinner edu = (Spinner)findViewById(R.id.form_educator);
        Spinner age = (Spinner)findViewById(R.id.form_age);
        Spinner gen = (Spinner)findViewById(R.id.form_gender);

        String query = year.getSelectedItem().toString() + ","
                + geo.getSelectedItem().toString() + ","
                + edu.getSelectedItem().toString() + ","
                + age.getSelectedItem().toString() + ","
                + gen.getSelectedItem().toString();

        // Search asynctask -  searches though csv file to find matching string
        new SearchTask(getApplicationContext()).execute(query);
    }

    // Loads Result activity without submitting any new data
    public void toTable(View view) {
        new SearchTask(getApplicationContext()).execute("null");
    }

}
