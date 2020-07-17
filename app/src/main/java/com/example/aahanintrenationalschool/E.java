package com.example.aahanintrenationalschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class E extends AppCompatActivity {
    FirebaseAuth auth1;
    FirebaseAuth fAuth1;
    FirebaseUser user1;
    DatabaseReference reference1;
    DatabaseReference reference2;
    Button btn,btn1;
    TextView fname4, lname4,designation4,email4;
    EditText fname5, lname5,designation5, email5,country4,religion4,mobilenumber4,dob4,gender4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);
        fname4= findViewById(R.id.userFName1);
        lname4=findViewById(R.id.userLName1);
        designation4=findViewById(R.id.userDesignation1);
        email4=findViewById(R.id.userEmail1);
        btn=findViewById(R.id.btnUpdateProfile);
       btn1=findViewById(R.id.btnDeleteProfile);

        country4=findViewById(R.id.DCountry1);
        religion4=findViewById(R.id.DReligion1);
        mobilenumber4=findViewById(R.id.DMobile1);
        dob4=findViewById(R.id.DDOB1);
        gender4=findViewById(R.id.DGender1);
        lname5=findViewById(R.id.DLname1);
        designation5=findViewById(R.id.DDesignation1);
        email5=findViewById(R.id.DEmail1);
        fname5=findViewById(R.id.DFname1);



        auth1=FirebaseAuth.getInstance();
        fAuth1=FirebaseAuth.getInstance();
        user1= auth1.getCurrentUser();




        reference1= FirebaseDatabase.getInstance().getReference().child(user1.getUid());
        reference2 = FirebaseDatabase.getInstance().getReference();
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String firsname8= dataSnapshot.child("fname").getValue().toString();
                String lastname8= dataSnapshot.child("lname").getValue().toString();
                String designation8= dataSnapshot.child("designation").getValue().toString();
                String email8= dataSnapshot.child("email").getValue().toString();
                String country8= dataSnapshot.child("country").getValue().toString();
                String religion8= dataSnapshot.child("religion").getValue().toString();
                String mobilenumber8= dataSnapshot.child("mno").getValue().toString();
                String dob8= dataSnapshot.child("dob").getValue().toString();
                String gender8= dataSnapshot.child("gender").getValue().toString();

                fname4.setText(firsname8);
                fname5.setText(firsname8);
                lname4.setText(lastname8);
                lname5.setText(lastname8);
                designation4.setText(designation8);
                designation5.setText(designation8);
                email4.setText(email8);
                email5.setText(email8);
                country4.setText(country8);
                religion4.setText(religion8);
                mobilenumber4.setText(mobilenumber8);
                dob4.setText(dob8);
                gender4.setText(gender8);




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String fname12=fname5.getText().toString().trim();
            final String lname12=lname5.getText().toString().trim();
            final String Designation12=designation5.getText().toString().trim();
            final String Email12=email5.getText().toString().trim();

            final String country12=country4.getText().toString().trim();
            final String religion12=religion4.getText().toString().trim();
            final String mno12=mobilenumber4.getText().toString().trim();
            final String dob12=dob4.getText().toString().trim();



            if(TextUtils.isEmpty(fname12)){
                fname5.setError("First Name is Required");
                return;
            }
            else if(TextUtils.isEmpty(lname12)){
                lname5.setError("Last Name is Required");
                return;
            }
            else if(TextUtils.isEmpty(Designation12)){
                designation5.setError("Designation is Required");
                return;
            }
            else if(TextUtils.isEmpty(Email12)){
                email5.setError("Email is Required");
                return;
            }


            else  if(TextUtils.isEmpty(country12)){
                country4.setError("Country is Required");
                return;
            }
            else  if(TextUtils.isEmpty(religion12)){
                religion4.setError("Religion is Required");
                return;
            }
            else  if(TextUtils.isEmpty(mno12)){
                mobilenumber4.setError("Contact no is Required");
                return;
            }
            else if(TextUtils.isEmpty(dob12)){
                dob4.setError("DOB is Required");
                return;
            }else{
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reference1.child("fname").setValue(fname12);
                        reference1.child("lname").setValue(lname12);
                        reference1.child("designation").setValue(Designation12);

                        reference1.child("country").setValue(country12);
                        reference1.child("religion").setValue(religion12);
                        reference1.child("mno").setValue(mno12);
                        reference1.child("dob").setValue(dob12);

                        Toast.makeText(E.this, "Update Successfully!!", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(getApplicationContext(), Profile.class));



                    }
                });
            }

        }
    });
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FirebaseAuth.getInstance().signOut();
            reference1.removeValue();

            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }
    });


    }


    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(E.this,"Logged Out",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}

