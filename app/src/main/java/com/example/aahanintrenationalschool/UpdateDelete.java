package com.example.aahanintrenationalschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateDelete extends AppCompatActivity {
    EditText fn,ln,des,pwd,cnt,em,rel,mn,db;
    FirebaseUser user;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        fn=findViewById(R.id.editFirstName9);
        ln=findViewById(R.id.editLastName9);
        des=findViewById(R.id.editDesignation9);
        pwd=findViewById(R.id.editPassword9);
        cnt=findViewById(R.id.editCountry9);
        em=findViewById(R.id.editEmail9);
        rel=findViewById(R.id.editReligion9);
        mn =findViewById(R.id.editMobileNumber9);
        db=findViewById(R.id.editDOB9);

        /*String key=getIntent().getExtras().get("key").toString();

       // ref= FirebaseDatabase.getInstance().getReference().child(user.getUid());

        fn.setText(getIntent().getStringExtra("fn"));
        ln.setText(getIntent().getStringExtra("ln"));
        des.setText(getIntent().getStringExtra("des"));
        pwd.setText(getIntent().getStringExtra("pwd"));
        cnt.setText(getIntent().getStringExtra("cnt"));
        em.setText(getIntent().getStringExtra("em"));
        rel.setText(getIntent().getStringExtra("rel"));
        mn.setText(getIntent().getStringExtra("mn"));
        db.setText(getIntent().getStringExtra("db"));*/
    }
}
