package com.example.class_1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button Home;

    @Override
    public void onCreate(Bundle savedInstaneState){
        super.onCreate(savedInstaneState);
        setContentView(R.layout.activity_home);

        Home=findViewById(R.id.home);

        Home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
