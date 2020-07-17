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

public class Login extends AppCompatActivity {
    EditText email, password;
    Button signin;
    TextView textView;
    FirebaseAuth fAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.editUsername);
        password=findViewById(R.id.editPassword);
        signin=findViewById(R.id.btnLogin);
        textView=findViewById(R.id.waringID);

        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Profile.class));
            finish();
        }

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email1=email.getText().toString();
                String Password1=password.getText().toString();
                if(TextUtils.isEmpty(Email1)){
                    email.setError("Please enter email id");
                   return;

                }
                if(TextUtils.isEmpty(Password1)){
                    password.setError("Password is Required");
                    return;
                }
                if(Password1.length()<6){
                    password.setError("Password must be greater then 6  character");
                    return;
                }

                fAuth.signInWithEmailAndPassword(Email1, Password1).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login Successfully!!", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(), Profile.class));
                            finish();
                        } else {
                            Toast.makeText(Login.this, "Email or Password Incorrect!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Signup.class));
                finish();
            }
        });
    }
}
