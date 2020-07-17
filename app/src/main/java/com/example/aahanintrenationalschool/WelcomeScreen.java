package com.example.aahanintrenationalschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class WelcomeScreen extends AppCompatActivity {
    private static int Splash_time_out=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent homeIntent=new Intent(WelcomeScreen.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },Splash_time_out);
    }

}
