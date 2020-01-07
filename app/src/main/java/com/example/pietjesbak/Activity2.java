package com.example.pietjesbak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv = (TextView) findViewById(R.id.textView6);
        tv2 = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            String string2 = extras.getString("PLAYER1");
            String string4 = extras.getString("PLAYER2");

            tv.setText(string4);
            tv2.setText(string2);

        check1 = findViewById(R.id.checkBox);
        check2 = findViewById(R.id.checkBox2);
        check3 = findViewById(R.id.checkBox3);



    }




}
