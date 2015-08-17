package com.example.andy.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Result extends Activity {

    public String res;
    public String[] history = {"null","null","null","null","null"};
    public Etc[] val = {new Etc(), new Etc(), new Etc(), new Etc(), new Etc()};
    public int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        res = extras.getString("res");

        //Toast.makeText(this, res, Toast.LENGTH_SHORT).show();

        // Read history file
        File file = new File (Environment.getExternalStorageDirectory().getAbsolutePath(), "Res");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.equals("null")) {
                    val[i] = new Etc(line);
                    history[i] = line;
                    i++;
                }
            }
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Read User Input, if the search count is at 5, replace the last search with the new one
        // 5 is the number of queries that I would like to have displayed at a time
        if (!res.equals("null")) {
            if (i < 5) {
                history[i] = res;
                val[i] = new Etc(res);
            } else {
                val[4] = new Etc(res);
                history[4] = res;
            }
        }

        // Write to history
        try {
            FileWriter w = new FileWriter(file);
            for (String s : history) {
                if (!res.equals("null")) {
                    w.write(s);
                    w.write(System.getProperty("line.separator"));
                }
            }
            w.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Build Table Code, used code similar to/used code as guideline
        // http://code.tutsplus.com/tutorials/android-user-interface-design-table-layouts--mobile-4788
        // The idea of the code is to programmatically build the table with the data
        TableLayout table = new TableLayout(this);

        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);
        // build rows
        TableRow rowZero = new TableRow(this);
        TableRow rowOne = new TableRow(this);
        TableRow rowTwo = new TableRow(this);
        TableRow rowThree = new TableRow(this);
        TableRow rowFour = new TableRow(this);
        TableRow rowFive = new TableRow(this);

        //build column Year
        TextView labelYear = new TextView(this);
        labelYear.setText("Year");
        labelYear.setTypeface(Typeface.DEFAULT_BOLD);

        TextView zeroYear = new TextView(this);
        zeroYear.setText(val[0].year);

        TextView oneYear = new TextView(this);
        oneYear.setText(val[1].year);

        TextView twoYear = new TextView(this);
        twoYear.setText(val[2].year);

        TextView threeYear = new TextView(this);
        threeYear.setText(val[3].year);

        TextView fourYear = new TextView(this);
        fourYear.setText(val[4].year);

        rowZero.addView(labelYear);
        rowOne.addView(zeroYear);
        rowTwo.addView(oneYear);
        rowThree.addView(twoYear);
        rowFour.addView(threeYear);
        rowFive.addView(fourYear);

        //build column Geo
        TextView labelGeo = new TextView(this);
        labelGeo.setText("Geo");
        labelGeo.setTypeface(Typeface.DEFAULT_BOLD);

        TextView zeroGeo = new TextView(this);
        zeroGeo.setText(val[0].geo);

        TextView oneGeo = new TextView(this);
        oneGeo.setText(val[1].geo);

        TextView twoGeo = new TextView(this);
        twoGeo.setText(val[2].geo);

        TextView threeGeo = new TextView(this);
        threeGeo.setText(val[3].geo);

        TextView fourGeo = new TextView(this);
        fourGeo.setText(val[4].geo);

        rowZero.addView(labelGeo);
        rowOne.addView(zeroGeo);
        rowTwo.addView(oneGeo);
        rowThree.addView(twoGeo);
        rowFour.addView(threeGeo);
        rowFive.addView(fourGeo);

        //build column Work
        TextView labelWork = new TextView(this);
        labelWork.setText("Work");
        labelWork.setTypeface(Typeface.DEFAULT_BOLD);

        TextView zeroWork = new TextView(this);
        zeroWork.setText(val[0].work);

        TextView oneWork = new TextView(this);
        oneWork.setText(val[1].work);

        TextView twoWork = new TextView(this);
        twoWork.setText(val[2].work);

        TextView threeWork = new TextView(this);
        threeWork.setText(val[3].work);

        TextView fourWork = new TextView(this);
        fourWork.setText(val[4].work);

        rowZero.addView(labelWork);
        rowOne.addView(zeroWork);
        rowTwo.addView(oneWork);
        rowThree.addView(twoWork);
        rowFour.addView(threeWork);
        rowFive.addView(fourWork);

        //build column Age
        TextView labelAge = new TextView(this);
        labelAge.setText("Age");
        labelAge.setTypeface(Typeface.DEFAULT_BOLD);


        TextView zeroAge = new TextView(this);
        zeroAge.setText(val[0].age);

        TextView oneAge = new TextView(this);
        oneAge.setText(val[1].age);

        TextView twoAge = new TextView(this);
        twoAge.setText(val[2].age);

        TextView threeAge = new TextView(this);
        threeAge.setText(val[3].age);

        TextView fourAge = new TextView(this);
        fourAge.setText(val[4].age);

        rowZero.addView(labelAge);
        rowOne.addView(zeroAge);
        rowTwo.addView(oneAge);
        rowThree.addView(twoAge);
        rowFour.addView(threeAge);
        rowFive.addView(fourAge);

        //build column Gender
        TextView labelSex = new TextView(this);
        labelSex.setText("Gender");
        labelSex.setTypeface(Typeface.DEFAULT_BOLD);

        TextView zeroSex = new TextView(this);
        zeroSex.setText(val[0].sex);

        TextView oneSex = new TextView(this);
        oneSex.setText(val[1].sex);

        TextView twoSex = new TextView(this);
        twoSex.setText(val[2].sex);

        TextView threeSex = new TextView(this);
        threeSex.setText(val[3].sex);

        TextView fourSex = new TextView(this);
        fourSex.setText(val[4].sex);

        rowZero.addView(labelSex);
        rowOne.addView(zeroSex);
        rowTwo.addView(oneSex);
        rowThree.addView(twoSex);
        rowFour.addView(threeSex);
        rowFive.addView(fourSex);

        //build column Value
        TextView labelValue = new TextView(this);
        labelValue.setText("Value");
        labelValue.setTypeface(Typeface.DEFAULT_BOLD);

        TextView zeroValue = new TextView(this);
        zeroValue.setText(val[0].value);

        TextView oneValue = new TextView(this);
        oneValue.setText(val[1].value);

        TextView twoValue = new TextView(this);
        twoValue.setText(val[2].value);

        TextView threeValue = new TextView(this);
        threeValue.setText(val[3].value);

        TextView fourValue = new TextView(this);
        fourValue.setText(val[4].value);

        rowZero.addView(labelValue);
        rowOne.addView(zeroValue);
        rowTwo.addView(oneValue);
        rowThree.addView(twoValue);
        rowFour.addView(threeValue);
        rowFive.addView(fourValue);

        table.addView(rowZero);
        table.addView(rowOne);
        table.addView(rowTwo);
        table.addView(rowThree);
        table.addView(rowFour);
        table.addView(rowFive);

        // Display Table
        setContentView(table);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        // Used to clear table and history. Refreshes the activity
        if (id == R.id.clear) {
            try {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "Res");
                for (i = 0; i < 5; i++) {
                    history[i] = "null";
                }
                PrintWriter writer = new PrintWriter(file);
                writer.print("");
                writer.close();
                res = "null";
                Intent intent = getIntent();
                intent.putExtra("res", "null");
                finish();
                startActivity(intent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
