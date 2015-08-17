package com.example.andy.test;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Andy on 2015-08-15.
 */
public class SearchTask extends AsyncTask<String, Void, Void> {

    Context context;
    public String s = "null";
    public SearchTask(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    protected Void doInBackground(String... params) {
        // Queries data file and stores the line of data
        File file = new File (Environment.getExternalStorageDirectory().getAbsolutePath(), "/data/04770028-eng.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(params[0])){
                    s = line;
                    br.close();
                    return null;
                }
            }
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Starts result activity on completion
        Intent r = new Intent(context, Result.class);
        r.putExtra("res", s);
        r.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(r);
    }
}




