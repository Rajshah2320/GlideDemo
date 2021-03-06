package com.example.glide;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {
    private Button mainBtn;
    private ImageView mainImg;
    private DatabaseReference databaseReference;
    private String mImgUrl;
    private StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBtn=findViewById(R.id.main_btn);
        mainImg=findViewById(R.id.main_img);
      /*
        storageReference= FirebaseStorage.getInstance().getReference().child("Main");
        storageReference.child("1.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
           @Override
           public void onSuccess(Uri uri) {
               mImgUrl=uri.toString();
           }
       });
*/
   // Glide.with(MainActivity.this).load("https://www.googleapis.com/storage/v1/b/fir-demo-b26a3.appspot.com/o/Main%2F1.png").into(mainImg);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Main");
       databaseReference.child("1").addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               mImgUrl=dataSnapshot.getValue().toString();

               Log.i("Entered m Url", mImgUrl);
              Glide.with(MainActivity.this).load(mImgUrl).into(mainImg);

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });




        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Activity2.class));
            }
        });
    }
}
