package com.example.glide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity2 extends AppCompatActivity {
    private Button act2Btn;
    private ImageView act2Img;
    private DatabaseReference databaseReference;
    private String mImgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        act2Btn=findViewById(R.id.act2_btn);
        act2Img=findViewById(R.id.act2_img);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Main").child("Act2");
        databaseReference.child("2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mImgUrl=dataSnapshot.getValue().toString();
                Log.i("Url 2", mImgUrl);
                Glide.with(Activity2.this).load(mImgUrl).into(act2Img);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        act2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity2.this,Activity3.class));
            }
        });
    }
}
