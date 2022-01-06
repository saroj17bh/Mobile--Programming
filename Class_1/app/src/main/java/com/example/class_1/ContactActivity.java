package com.example.class_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {

    Button Contact;

    @Override
    public void onCreate(Bundle savedInstaneState){
        super.onCreate(savedInstaneState);
        setContentView(R.layout.activity_contact);

        Contact=findViewById(R.id.contact);

        Contact.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i = new Intent(ContactActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
