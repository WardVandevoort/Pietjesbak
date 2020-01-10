package com.example.pietjesbak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Activity_3 extends AppCompatActivity {

    String winnaar;
    String verliezer;
    TextView tv7;
    Button btn1;
    Button btn2;
    CallbackManager callbackManager;
    ShareDialog shareDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_3);

        printKeyHash();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        winnaar = extras.getString("WINNAAR");
        verliezer = extras.getString("VERLIEZER");

        tv7 = findViewById(R.id.textView7);
        btn1 = findViewById(R.id.button5);
        btn2 = findViewById(R.id.button4);
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);



        tv7.setText(winnaar + " is de winnaar!");

        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                OpenActivity();


            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                ShareLinkContent linkContent = new ShareLinkContent.Builder()
                        .setQuote(winnaar + " is tijdens een spelletje Pietjesbak gewonnen van " + verliezer)
                        .setContentUrl(Uri.parse("https://www.google.com"))
                        .build();
                if(ShareDialog.canShow(ShareLinkContent.class)){
                    shareDialog.show(linkContent);
                }
            }

        });
    }

    public void printKeyHash(){

        try{

            PackageInfo info = getPackageManager().getPackageInfo("com.example.pietjesbak",
                    PackageManager.GET_SIGNATURES);
            for(Signature signature : info.signatures){

                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(),Base64.DEFAULT));

            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public void OpenActivity(){
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
}
