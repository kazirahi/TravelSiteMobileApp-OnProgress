package com.example.aahanintrenationalschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    FirebaseUser user;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        member= new Member();
        listView=findViewById(R.id.listview);
        firebaseDatabase=FirebaseDatabase.getInstance();
        reference=firebaseDatabase.getReference();
        list= new ArrayList<String>();
        adapter=new ArrayAdapter<>(this,R.layout.membarlist,R.id.listname, list);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    member=ds.getValue(Member.class);
                    list.add(member.getFname().toString()+" "+member.getLname().toString());
                }
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(Admin.this,UpdateDelete.class);
                        Member m=(Member)adapterView.getItemAtPosition(i);
                        /*intent.putExtra("fn",m.getFname());
                        intent.putExtra("ln",m.getLname());
                        intent.putExtra("des",m.getDesignation());
                        intent.putExtra("pwd",m.getPassword());
                        intent.putExtra("cnt",m.getCountry());
                        intent.putExtra("em",m.getEmail());
                        intent.putExtra("rel",m.getReligion());
                        intent.putExtra("mn",m.getMno());
                        intent.putExtra("db",m.getDob());*/
                        //intent.putExtra("key",(user.getUid()));
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
