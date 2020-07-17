package com.example.aahanintrenationalschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference reference;
    Button btn;
    TextView fname, lname,designation2,email2,fname1, lname1,designation1, email1,country1,religion1,mobilenumber1,dob1,gender1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fname= findViewById(R.id.userFName);
        lname=findViewById(R.id.userLName);
        designation2=findViewById(R.id.userDesignation);
        email2=findViewById(R.id.userEmail);
        btn=findViewById(R.id.btnEditProfile);

        country1=findViewById(R.id.DCountry);
        religion1=findViewById(R.id.DReligion);
        mobilenumber1=findViewById(R.id.DMobile);
        dob1=findViewById(R.id.DDOB);
        gender1=findViewById(R.id.DGender);
        lname1=findViewById(R.id.DLname);
        designation1=findViewById(R.id.DDesignation);
        email1=findViewById(R.id.DEmail);
        fname1=findViewById(R.id.DFname);



        auth=FirebaseAuth.getInstance();
        user= auth.getCurrentUser();




        reference= FirebaseDatabase.getInstance().getReference().child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String firsname= dataSnapshot.child("fname").getValue().toString();
                String lastname= dataSnapshot.child("lname").getValue().toString();
                String designation= dataSnapshot.child("designation").getValue().toString();
                String email= dataSnapshot.child("email").getValue().toString();
                String country= dataSnapshot.child("country").getValue().toString();
                String religion= dataSnapshot.child("religion").getValue().toString();
                String mobilenumber= dataSnapshot.child("mno").getValue().toString();
                String dob= dataSnapshot.child("dob").getValue().toString();
                String gender= dataSnapshot.child("gender").getValue().toString();

                fname.setText(firsname);
                fname1.setText(firsname);
                lname.setText(lastname);
                lname1.setText(lastname);
                designation2.setText(designation);
                designation1.setText(designation);
                email1.setText(email);
                email2.setText(email);
                country1.setText(country);
                religion1.setText(religion);
                mobilenumber1.setText(mobilenumber);
                dob1.setText(dob);
                gender1.setText(gender);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void editbtn(View view){

        startActivity(new Intent(getApplicationContext(), E.class));
        finish();
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(Profile.this,"Logged Out",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}
