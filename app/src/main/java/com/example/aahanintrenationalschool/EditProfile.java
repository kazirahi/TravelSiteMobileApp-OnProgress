package com.example.aahanintrenationalschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfile extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference reference;
    EditText fname,laname,email1,designation1, password1,country1, religion1,mno,dob1;
    Button signup;
    RadioGroup radioGroup;
    RadioButton rm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //radioGroup=findViewById(R.id.radiogroup);
        fname=findViewById(R.id.editFirstName);
        laname=findViewById(R.id.editLastName);
        designation1=findViewById(R.id.editDesignation);
        email1=findViewById(R.id.editEmail);
        password1=findViewById(R.id.editPassword);
        country1=findViewById(R.id.editCountry);
        mno=findViewById(R.id.editMobileNumber);
        religion1=findViewById(R.id.editReligion);
        dob1=findViewById(R.id.editDOB);
        signup=findViewById(R.id.btnSignup);
        int radioID=radioGroup.getCheckedRadioButtonId();
        //rm=findViewById(radioID);

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
                //String gender= dataSnapshot.child("gender").getValue().toString();
                Toast.makeText(getApplicationContext(),firsname,Toast.LENGTH_SHORT).show();
                fname.setText(firsname);

                laname.setText(lastname);


                designation1.setText(designation);

                email1.setText(email);
                country1.setText(country);
                religion1.setText(religion);
                mno.setText(mobilenumber);
                dob1.setText(dob);
                //rm.setText(gender);




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*public void checkButton(View v){
        int radioID=radioGroup.getCheckedRadioButtonId();
        rm=findViewById(radioID);
        String gender= rm.getText().toString().trim();
    }*/
}
