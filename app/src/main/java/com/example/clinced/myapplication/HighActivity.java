package com.example.clinced.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    public Calendar highCalendar;
    public String dateStr;
    public Button highButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high);

        highCalendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
        dateStr = "Recorded on " + dateFormat.format(highCalendar.getTime());

        highButton = (Button) findViewById(R.id.high_submit);

        highButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HighActivity.this, AfterSubmitActivity.class));
            }
        });




    }
}
