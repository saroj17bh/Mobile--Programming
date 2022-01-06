package com.example.class_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Home,Contact,Camera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Home = findViewById(R.id.home);
        Contact = findViewById(R.id.contact);
        Camera = findViewById(R.id.camera);

        Home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

        Contact.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this,ContactActivity.class);
                startActivity(i);
            }
        });

        Camera.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(i);
            }
        });



    }
}