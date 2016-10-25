package com.example.clinced.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
//import android.support.v7.app.AppCompatActivity;

/**
 * Created by clinced on 17/09/16.
 */
public class LowActivity extends AppCompatActivity {

    public Calendar lowCalendar;
    public Button lowButton;
    public String lowDateStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low);

        lowCalendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM//yyyy 'at' HH:mm");
        lowDateStr = "Recorded on " + dateFormat.format(lowCalendar.getTime());

        lowButton = (Button) findViewById(R.id.low_submit);

        lowButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LowActivity.this, AfterSubmitActivity.class));
            }
        });
    }
}
