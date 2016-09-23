package com.example.clinced.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by clinced on 17/09/16.
 */
public class HighActivity extends AppCompatActivity{

    ListView listView;
    public Calendar highCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high);

        highCalendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
        String dateStr = "Recorded on " + dateFormat.format(highCalendar.getTime());

        //TextView textView = (TextView) findViewById(R.id.high_engine_text);
        //textView.setText(dateStr);


        //get listview object
        listView = (ListView) findViewById(R.id.high_list);

        //define array values for list
        String [] values = new String [] {"Activity One",
                "Activity Two", "Activity Three", "Activity Four",
                "Activity Five", "Activity Six", "Activity Seven",
                "Activity Eight", "Activity Nine"
        };

        //Define a new adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        //Assign adapter to ListView
        listView.setAdapter(adapter);

        //Listview click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition = position;
                String itemValue = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Position:" +itemPosition+ " ListItem:"+ itemValue, Toast.LENGTH_LONG).show();
            }
        });



    }



}
