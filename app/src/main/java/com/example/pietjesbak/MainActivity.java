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
    String string1;
    String string2;
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
                string1 = et.getText().toString();
                string2 = et2.getText().toString();


                if(string1.equals("") || string1.equals(" ") || string2.equals("") || string2.equals(" ")){

                    Toast.makeText (getApplicationContext(),error1, Toast.LENGTH_LONG).show();

                }
                else{

                    openActivity2();

                }


            }

        });


    }

    public void openActivity2(){

        Intent intent = new Intent(this, Activity2.class);
        Bundle extras = new Bundle();
        extras.putString("PLAYER1",string1);
        extras.putString("PLAYER2",string2);
        intent.putExtras(extras);
        startActivity(intent);

    }

}
