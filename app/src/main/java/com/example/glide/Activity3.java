package com.example.glide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity3 extends AppCompatActivity {

    private ImageView act3Img;
    private DatabaseReference databaseReference;
    private String mImgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        act3Img=findViewById(R.id.act3_img);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Main").child("Act2").child("Act3");
        databaseReference.child("3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mImgUrl=dataSnapshot.getValue().toString();

                Log.i("Url3", mImgUrl);
                 Glide.with(Activity3.this).load(mImgUrl).into(act3Img);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        };


    }

