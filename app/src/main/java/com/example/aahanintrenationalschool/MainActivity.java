package com.example.aahanintrenationalschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button sin,sup,admin1;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sin=findViewById(R.id.signin);
        sup=findViewById(R.id.signup);
        admin1=findViewById(R.id.admin);
        FirebaseAuth.getInstance().signOut();
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this,Login.class );
                startActivity(intent);

            }
        });
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this,Signup.class );
                startActivity(intent);

            }
        });
        admin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this,Admin.class );
                startActivity(intent);

            }
        });



    }

}
