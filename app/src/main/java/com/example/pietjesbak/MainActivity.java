package com.example.pietjesbak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;
    String string1 = "Welkom ";
    String string2;
    String string3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.inputField);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                string2 = et.getText().toString();
                

                string3 = string1 + string2;

                Toast.makeText (getApplicationContext(),string3, Toast.LENGTH_LONG).show();
            }

        });
    }
}
