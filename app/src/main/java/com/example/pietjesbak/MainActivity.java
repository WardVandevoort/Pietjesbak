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
    EditText et2;
    Button btn;
    String string1 = "Welkom ";
    String string2;
    String string3 = " en ";
    String string4;
    String string5;
    String error1 = "Beide spelers moeten een naam kiezen";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.inputField);
        et2 = (EditText) findViewById(R.id.inputField2);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                string2 = et.getText().toString();
                string4 = et2.getText().toString();

                string5 = string1 + string2 + string3 + string4;

                if(string2.equals("") || string2.equals(" ") || string4.equals("") || string4.equals(" ")){

                    Toast.makeText (getApplicationContext(),error1, Toast.LENGTH_LONG).show();

                }
                else{


                    Toast.makeText (getApplicationContext(),string5, Toast.LENGTH_LONG).show();
                    openActivity2();

                }


            }

        });


    }

    public void openActivity2(){

        Intent intent = new Intent(this, Activity2.class);
        Bundle extras = new Bundle();
        extras.putString("PLAYER1",string2);
        extras.putString("PLAYER2",string4);
        intent.putExtras(extras);
        startActivity(intent);

    }

}
