package com.example.aahanintrenationalschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rm;
    EditText fname,laname,email,designation, password,country, religion,mno,dob;
    Button signup;
    TextView textView;
    DatabaseReference reff;
    Member member;
    //long maxid=0;
    FirebaseAuth fAuth;
    FirebaseUser user;
   FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        radioGroup=findViewById(R.id.radiogroup);
        fname=findViewById(R.id.editFirstName);
        laname=findViewById(R.id.editLastName);
        designation=findViewById(R.id.editDesignation);
        email=findViewById(R.id.editEmail);
        password=findViewById(R.id.editPassword);
        country=findViewById(R.id.editCountry);
        mno=findViewById(R.id.editMobileNumber);
        religion=findViewById(R.id.editReligion);
        dob=findViewById(R.id.editDOB);
        signup=findViewById(R.id.btnSignup);
        member= new Member();
        textView=findViewById(R.id.waringID);
        fAuth=FirebaseAuth.getInstance();
        reff= FirebaseDatabase.getInstance().getReference();
        /*reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Profile.class));
            finish();
        }


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioID=radioGroup.getCheckedRadioButtonId();
                rm=findViewById(radioID);
                String gender= rm.getText().toString().trim();
                final String fname1=fname.getText().toString().trim();
                final String lname1=laname.getText().toString().trim();
                final String Designation1=designation.getText().toString().trim();
                final String Email1=email.getText().toString().trim();
                final String Password1=password.getText().toString().trim();
                final String country1=country.getText().toString().trim();
                final String religion1=religion.getText().toString().trim();
                final String mno1=mno.getText().toString().trim();
                final String dob1=dob.getText().toString().trim();

                member.setFname(fname.getText().toString().trim());
                member.setLname(laname.getText().toString().trim());
                member.setDesignation(designation.getText().toString().trim());
                member.setEmail(email.getText().toString().trim());
                member.setPassword(password.getText().toString().trim());
                member.setCountry(country.getText().toString().trim());
                member.setReligion(religion.getText().toString().trim());
                member.setMno(mno.getText().toString().trim());
                member.setDob(dob.getText().toString().trim());

                member.setGender(gender);
                //reff.push().setValue(member);
                //reff.child(String.valueOf(maxid+1)).setValue(member);
                //Toast.makeText(Signup.this, "Data Inserted Successfully!",Toast.LENGTH_SHORT).show();

                if(TextUtils.isEmpty(fname1)){
                    fname.setError("First Name is Required");
                    return;
                }
                else if(TextUtils.isEmpty(lname1)){
                    laname.setError("Last Name is Required");
                    return;
                }
                else if(TextUtils.isEmpty(Designation1)){
                    designation.setError("Designation is Required");
                    return;
                }
                else if(TextUtils.isEmpty(Email1)){
                    email.setError("Email is Required");
                    return;
                }
                else if(TextUtils.isEmpty(Password1)){
                    password.setError("Password is Required");
                    return;
                }
                else  if(Password1.length()<6){
                    password.setError("Password must be greater then 6  character");
                    return;
                }
                else  if(TextUtils.isEmpty(country1)){
                    country.setError("Country is Required");
                    return;
                }
                else  if(TextUtils.isEmpty(religion1)){
                    religion.setError("Religion is Required");
                    return;
                }
                else  if(TextUtils.isEmpty(mno1)){
                    mno.setError("Contact no is Required");
                    return;
                }
                else if(TextUtils.isEmpty(dob1)){
                    dob.setError("DOB is Required");
                    return;
                }
                else {
                    fAuth.createUserWithEmailAndPassword(Email1,Password1).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                               user=fAuth.getCurrentUser();

                               reff.child(user.getUid()).setValue(member)
                                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                                           @Override
                                           public void onComplete(@NonNull Task<Void> task) {
                                               Toast.makeText(Signup.this,"User Createrd Successfully!!",Toast.LENGTH_SHORT).show();
                                               finish();
                                               startActivity(new Intent(getApplicationContext(), Profile.class));

                                           }
                                       });
                            }
                            else{
                                Toast.makeText(Signup.this,"Error! Try Again!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }



            }
        });









        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });



    }

    public void checkButton(View v){
            int radioID=radioGroup.getCheckedRadioButtonId();
            rm=findViewById(radioID);
            String gender= rm.getText().toString().trim();
    }
}
