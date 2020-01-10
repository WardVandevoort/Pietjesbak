package com.example.pietjesbak;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Timer;
import java.util.TimerTask;

public class Activity2 extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    TextView tv4;
    TextView tv5;
    View v1;
    View v2;
    View v3;
    View v4;
    View v5;
    View v6;
    View v7;
    View v8;
    View v9;
    View v10;
    View v11;
    View v12;
    View v13;
    View v14;
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    String string1;
    String string2;
    Button btn;
    Button btn2;
    ImageView ds1;
    ImageView ds2;
    ImageView ds3;
    Boolean drieApen1 = false;
    Boolean soixanteNeuf1 = false;
    Boolean zand1 = false;
    Boolean drieApen2 = false;
    Boolean soixanteNeuf2 = false;
    Boolean zand2 = false;
    int dobbelsteen1;
    int dobbelsteen2;
    int dobbelsteen3;
    int totaal1;
    int totaal2;
    int beurtB = 0;
    int beurtG = 0;
    int beurt;
    int i = 0;
    int i2 = 0;
    int a;
    Boolean p1 = true;
    Boolean p2 = true;
    Boolean exaequo = false;
    int kansen1 = 3;
    int kansen2 = 3;
    int img[] =  {R.drawable.dice1,
                  R.drawable.dice2,
                  R.drawable.dice3,
                  R.drawable.dice4,
                  R.drawable.dice5,
                  R.drawable.dice6};
    int min = -1;
    int dobbel;
    Boolean cb1 = true;
    Boolean cb2 = true;
    Boolean cb3 = true;


    ArrayList<View> streepjes1;
    ArrayList<View> streepjes2;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv = findViewById(R.id.textView6);
        tv2 = findViewById(R.id.textView2);
        v1 = findViewById(R.id.view1);
        v2 = findViewById(R.id.view2);
        v3 = findViewById(R.id.view3);
        v4 = findViewById(R.id.view4);
        v5 = findViewById(R.id.view5);
        v6 = findViewById(R.id.view6);
        v7 = findViewById(R.id.view7);
        v8 = findViewById(R.id.view8);
        v9 = findViewById(R.id.view9);
        v10 = findViewById(R.id.view10);
        v11 = findViewById(R.id.view11);
        v12 = findViewById(R.id.view12);
        v13 = findViewById(R.id.view13);
        v14 = findViewById(R.id.view14);

        streepjes1 = new ArrayList<>();
        streepjes1.add(v1);
        streepjes1.add(v2);
        streepjes1.add(v3);
        streepjes1.add(v4);
        streepjes1.add(v5);
        streepjes1.add(v6);
        streepjes1.add(v7);

        streepjes2 = new ArrayList<>();
        streepjes2.add(v8);
        streepjes2.add(v9);
        streepjes2.add(v10);
        streepjes2.add(v11);
        streepjes2.add(v12);
        streepjes2.add(v13);
        streepjes2.add(v14);




        Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            string1 = extras.getString("PLAYER1");
            string2 = extras.getString("PLAYER2");

            tv.setText(string2);
            tv2.setText(string1);

        String toast1 = "Bepaal wie mag beginnen, " + string1 + " gooit een dobbelsteen.";

                Toast.makeText (getApplicationContext(),toast1, Toast.LENGTH_LONG).show();

        check1 = findViewById(R.id.checkBox);
        check2 = findViewById(R.id.checkBox2);
        check3 = findViewById(R.id.checkBox3);
        btn = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button3);
        ds1 = findViewById(R.id.imageView2);
        ds2 = findViewById(R.id.imageView3);
        ds3 = findViewById(R.id.imageView4);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);


        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                if(beurtB == 2){
                    beurtB = 3;
                }

                if(beurtB == 0) {
                    Start1();
                    String value = String.valueOf(dobbelsteen1);
                    String toast2 = string1 + " gooit " + value + " " + string2 + " gooit nu een dobbelsteen";

                    Toast.makeText(getApplicationContext(), toast2, Toast.LENGTH_LONG).show();
                    beurtB = 1;
                }
                else if(beurtB == 1){
                    Start2();

                    WieBegint();

                }

                if(beurtB == 3){
                    Game();
                }




            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(beurtG == 1){
                    kansen1 = 0;
                    kansen2 = 3;
                }
                else if(beurtG == 2){
                    kansen2 = 0;
                    kansen1 = 3;
                }


            }
        });

    }

    public void Game(){

        switch(beurtG){
            case 1:
                if(kansen1 > 0) {
                    WelkeDobbelstenen();
                    Punten1();
                    tv4.setText(totaal1 + " Punten");
                    kansen1--;

                    drieApen1 = false;
                    soixanteNeuf1 = false;
                    zand1 = false;



                }
                else{
                    beurtG++;
                    Specialekes1();
                    String toast6 = "De beurt is aan " + string2;

                    Toast.makeText(getApplicationContext(), toast6, Toast.LENGTH_LONG).show();
                    p1 = false;
                    Ronde();
                    if(totaal1 == totaal2 || exaequo == true) {
                        kansen2 = 1;
                    }
                    else{
                        kansen2 = 3;
                    }

                }

                break;

            case 2:
                if(kansen2 > 0) {
                    WelkeDobbelstenen();
                    Punten2();
                    tv5.setText(totaal2 + " Punten");
                    kansen2--;

                    drieApen2 = false;
                    soixanteNeuf2 = false;
                    zand2 = false;



                }
                else{
                    beurtG--;
                    Specialekes2();
                    String toast7 = "De beurt is aan " + string1;

                    Toast.makeText(getApplicationContext(), toast7, Toast.LENGTH_LONG).show();
                    p2 = false;
                    Ronde();
                    if(totaal1 == totaal2 || exaequo == true) {
                        kansen1 = 1;
                    }
                    else{
                        kansen1 = 3;
                    }
                }

                break;
        }







    }

    public void Ronde(){

        if(p1 == false && p2 == false) {
            if(totaal1 > totaal2){


                p1 = true;
                p2 = true;
                exaequo = false;
                StreepjeWeg();
                Winnaar();

            }
            else if(totaal1 < totaal2){


                p1 = true;
                p2 = true;
                exaequo = false;
                StreepjeWeg();
                Winnaar();

            }
            else{
                p1 = true;
                p2 = true;
                exaequo = true;
                if(beurtG == 1){
                    String toast10 = "ex aequo, beide spelers gooien 1 dobbelsteen " + string1 + " begint";

                    Toast.makeText(getApplicationContext(), toast10, Toast.LENGTH_LONG).show();
                }
                else if(beurtG == 2){
                    String toast11 = "ex aequo, beide spelers gooien 1 dobbelsteen " + string2 + " begint";

                    Toast.makeText(getApplicationContext(), toast11, Toast.LENGTH_LONG).show();
                }



            }
        }

    }

    public int Start1(){

        dobbelsteen1 = 1 + (int)(Math.random()*6);
        dobbel = dobbelsteen1 + min;
        ds1.setImageResource(img[dobbel]);
        return dobbelsteen1;

    }

    public int Start2(){


        dobbelsteen2 = 1 + (int)(Math.random()*6);
        dobbel = dobbelsteen2 + min;
        ds1.setImageResource(img[dobbel]);
        return dobbelsteen2;

    }

    public int Dobbelsteen1(){

        dobbelsteen1 = 1 + (int)(Math.random()*6);
        dobbel = dobbelsteen1 + min;
        ds1.setImageResource(img[dobbel]);
        return dobbelsteen1;

    }

    public int Dobbelsteen2(){

        if(exaequo == false){
            dobbelsteen2 = 1 + (int)(Math.random()*6);
            dobbel = dobbelsteen2 + min;
            ds2.setImageResource(img[dobbel]);
            return dobbelsteen2;
        }
        dobbelsteen2 = 0;
        return dobbelsteen2;
    }

    public int Dobbelsteen3(){

        if(exaequo == false) {
            dobbelsteen3 = 1 + (int)(Math.random()*6);
            dobbel = dobbelsteen3 + min;
            ds3.setImageResource(img[dobbel]);
            return dobbelsteen3;
        }
        dobbelsteen3 = 0;
        return dobbelsteen3;
    }

    public void WelkeDobbelstenen(){

        if(check1.isChecked()){
            cb1 = true;
        }
        else{
            cb1 = false;
        }

        if(check2.isChecked()){
            cb2 = true;
        }
        else{
            cb2 = false;
        }

        if(check3.isChecked()){
            cb3 = true;
        }
        else{
            cb3 = false;
        }

        if(cb1 == true){
            Dobbelsteen1();
        }

        if(cb2 == true){
            Dobbelsteen2();
        }

        if(cb3 == true){
            Dobbelsteen3();
        }

    }

    public int Punten1(){
        if(dobbelsteen1 == 1){
            dobbelsteen1 = 100;
        }
        else if(dobbelsteen1 == 6){
            dobbelsteen1 = 60;
        }

        if(dobbelsteen2 == 1){
            dobbelsteen2 = 100;
        }
        else if(dobbelsteen2 == 6){
            dobbelsteen2 = 60;
        }

        if(dobbelsteen3 == 1){
            dobbelsteen3 = 100;
        }
        else if(dobbelsteen3 == 6){
            dobbelsteen3 = 60;
        }

        totaal1 = dobbelsteen1 + dobbelsteen2 + dobbelsteen3;
        return totaal1;
    }

    public int Punten2(){
        if(dobbelsteen1 == 1){
            dobbelsteen1 = 100;
        }
        else if(dobbelsteen1 == 6){
            dobbelsteen1 = 60;
        }

        if(dobbelsteen2 == 1){
            dobbelsteen2 = 100;
        }
        else if(dobbelsteen2 == 6){
            dobbelsteen2 = 60;
        }

        if(dobbelsteen3 == 1){
            dobbelsteen3 = 100;
        }
        else if(dobbelsteen3 == 6){
            dobbelsteen3 = 60;
        }

        totaal2 = dobbelsteen1 + dobbelsteen2 + dobbelsteen3;
        return totaal2;
    }

    public void WieBegint(){
        String value2 = String.valueOf(dobbelsteen2);

        if(dobbelsteen1>dobbelsteen2){
            String toast3 = string2 + " gooit " + value2 + ", " + string1 + " gooit het hoogst, " + string1 + " begint";

            Toast.makeText(getApplicationContext(), toast3, Toast.LENGTH_LONG).show();
            beurtB = 2;
            beurtG = 1;
        }
        else if(dobbelsteen1<dobbelsteen2){
            String toast4 = string2 + " gooit " + value2 + ", " + string2 + " gooit het hoogst, " + string2 + " begint";

            Toast.makeText(getApplicationContext(), toast4, Toast.LENGTH_LONG).show();
            beurtB = 2;
            beurtG = 2;
        }
        else{
            String toast5 = string2 + " gooit " + value2 + ", ex aequo " + string1 + " gooit opnieuw";

            Toast.makeText(getApplicationContext(), toast5, Toast.LENGTH_LONG).show();
            beurtB = 0;
        }

    }

    public void Specialekes1(){

        if(dobbelsteen1 == dobbelsteen2 && dobbelsteen1 == dobbelsteen3){

            if(dobbelsteen1 == 100 && dobbelsteen2 == 100 && dobbelsteen3 == 100){

                drieApen1 = true;


            }
            else{
                zand1 = true;
            }


        }

        else if(dobbelsteen1 == 60 && dobbelsteen2 == 5 && dobbelsteen3 == 4 ||
                dobbelsteen1 == 5 && dobbelsteen2 == 4 && dobbelsteen3 == 60 ||
                dobbelsteen1 == 4 && dobbelsteen2 == 60 && dobbelsteen3 == 5 ||
                dobbelsteen1 == 60 && dobbelsteen2 == 4 && dobbelsteen3 == 5 ||
                dobbelsteen1 == 5 && dobbelsteen2 == 60 && dobbelsteen3 == 4 ||
                dobbelsteen1 == 4 && dobbelsteen2 == 5 && dobbelsteen3 == 60
                ){


                soixanteNeuf1 = true;


        }



    }

    public void Specialekes2(){

        if(dobbelsteen1 == dobbelsteen2 && dobbelsteen1 == dobbelsteen3){

            if(dobbelsteen1 == 100 && dobbelsteen2 == 100 && dobbelsteen3 == 100){

                drieApen2 = true;


            }
            else {
                zand2 = true;

            }
        }
        else if(dobbelsteen1 == 60 && dobbelsteen2 == 5 && dobbelsteen3 == 4 ||
                dobbelsteen1 == 5 && dobbelsteen2 == 4 && dobbelsteen3 == 60 ||
                dobbelsteen1 == 4 && dobbelsteen2 == 60 && dobbelsteen3 == 5 ||
                dobbelsteen1 == 60 && dobbelsteen2 == 4 && dobbelsteen3 == 5 ||
                dobbelsteen1 == 5 && dobbelsteen2 == 60 && dobbelsteen3 == 4 ||
                dobbelsteen1 == 4 && dobbelsteen2 == 5 && dobbelsteen3 == 60 ){


            soixanteNeuf2 = true;


        }


    }

    public void StreepjeWeg(){



        if(totaal1 > totaal2){
            if(zand1 == true){
                String toast16 = string1 + " gooit zand en wint deze ronde!";

                Toast.makeText(getApplicationContext(), toast16, Toast.LENGTH_LONG).show();
                for(a = 0; a < 2; a++){
                    streepjes1.get(i).setVisibility(View.INVISIBLE);
                    i++;
                }
            }
            else if(soixanteNeuf1 == true){
                String toast19 = string1 + " gooit soixante neuf en wint deze ronde!";

                Toast.makeText(getApplicationContext(), toast19, Toast.LENGTH_LONG).show();
                for(a = 0; a < 3; a++){
                    streepjes1.get(i).setVisibility(View.INVISIBLE);
                    i++;
                }
            }
            else if(drieApen1 == true){
                if(i > 0){
                    String toast12 = string1 + " gooit 3 apen en wint het spel!";

                    Toast.makeText(getApplicationContext(), toast12, Toast.LENGTH_LONG).show();
                    i = 7;
                }
                else{
                    String toast13 = string1 + " gooit 3 apen, maar heeft nog al zijn streepjes, " + string2 + " wint het spel!";

                    Toast.makeText(getApplicationContext(), toast13, Toast.LENGTH_LONG).show();
                    i2 = 7;
                }
            }
            else {
                String toast8 = string1 + " wint deze ronde!";

                Toast.makeText(getApplicationContext(), toast8, Toast.LENGTH_LONG).show();
                streepjes1.get(i).setVisibility(View.INVISIBLE);
                i++;
            }
        }
        else if(totaal1 < totaal2){
            if(zand2 == true){
                String toast17 = string2 + " gooit zand en wint deze ronde!";

                Toast.makeText(getApplicationContext(), toast17, Toast.LENGTH_LONG).show();
                for(a = 0; a < 2; a++){
                    streepjes2.get(i2).setVisibility(View.INVISIBLE);
                    i2++;
                }
            }
            else if(soixanteNeuf2 == true){
                String toast18 = string2 + " gooit soixante neuf en wint deze ronde!";

                Toast.makeText(getApplicationContext(), toast18, Toast.LENGTH_LONG).show();
                for(a = 0; a < 3; a++){
                    streepjes2.get(i2).setVisibility(View.INVISIBLE);
                    i2++;
                }
            }
            else if(drieApen2 == true){
                if(i2 > 0){
                    String toast14 = string2 + " gooit 3 apen en wint het spel!";

                    Toast.makeText(getApplicationContext(), toast14, Toast.LENGTH_LONG).show();
                    i2 = 7;
                }
                else{
                    String toast15 = string2 + " gooit 3 apen, maar heeft nog al zijn streepjes, " + string1 + " wint het spel!";

                    Toast.makeText(getApplicationContext(), toast15, Toast.LENGTH_LONG).show();
                    i = 7;
                }
            }
            else {
                String toast9 = string2 + " wint deze ronde!";

                Toast.makeText(getApplicationContext(), toast9, Toast.LENGTH_LONG).show();
                streepjes2.get(i2).setVisibility(View.INVISIBLE);
                i2++;
            }


        }



    }

    public void Winnaar(){

        if(i >= 7){
            String toast20 = string1 + " wint het spel!";

            Toast.makeText(getApplicationContext(), toast20, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, Activity_3.class);
            Bundle extras = new Bundle();
            extras.putString("WINNAAR",string1);
            extras.putString("VERLIEZER",string2);
            intent.putExtras(extras);
            startActivity(intent);


        }
        else if(i2 >= 7){
            String toast21 = string2 + " wint het spel!";

            Toast.makeText(getApplicationContext(), toast21, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, Activity_3.class);
            Bundle extras = new Bundle();
            extras.putString("WINNAAR",string2);
            extras.putString("VERLIEZER",string1);
            intent.putExtras(extras);
            startActivity(intent);


        }

    }





}
