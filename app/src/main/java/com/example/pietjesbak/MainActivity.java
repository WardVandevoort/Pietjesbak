package com.example.pietjesbak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    String error1 = "Kies een naam";



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

                if(string2.equals("") || string2.equals(" ")){

                    Toast.makeText (getApplicationContext(),error1, Toast.LENGTH_LONG).show();

                }
                else{


                    Toast.makeText (getApplicationContext(),string3, Toast.LENGTH_LONG).show();
                    openActivity2();

                }

            }

        });


    }

    public void openActivity2(){

        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);

    }

}
