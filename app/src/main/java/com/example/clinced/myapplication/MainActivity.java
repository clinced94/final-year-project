package com.example.clinced.myapplication;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button lowButton;
    private Button normButton;
    private Button highButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lowButton = (Button) findViewById(R.id.low_button);
        normButton = (Button) findViewById(R.id.norm_button);
        highButton = (Button) findViewById(R.id.high_button);

        lowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LowActivity.class));
            }
        });


        normButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NormActivity.class));
            }
        });

        highButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HighActivity.class));
            }
        });
    }



}
