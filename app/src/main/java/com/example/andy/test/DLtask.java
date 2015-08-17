package com.example.andy.test;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Andy on 2015-08-14.
 */
public class DLtask extends AsyncTask<String, Void, Void>  {

    Context context;
    DLtask (Context context) {
        this.context = context.getApplicationContext();
    }


    @Override
    protected Void doInBackground(String... params) {
        int count;

        try {

            // download file code copied and adapted from stackoverflow
            // http://stackoverflow.com/questions/15758856/android-how-to-download-file-from-webserver
            URL url = new URL(params[0]);
            URLConnection connection = url.openConnection();
            connection.connect();

            InputStream input = new BufferedInputStream(url.openStream(),
                    8192);

            OutputStream output = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "file"));

            byte data[] = new byte[1024];

            while ((count = input.read(data)) != -1) {
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        new UnZipTask(context).execute(Environment.getExternalStorageDirectory().getAbsolutePath() + "/file",
                Environment.getExternalStorageDirectory().getAbsolutePath() + "/data"); }
}
