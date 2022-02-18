package com.example.Assignment_3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Button signup;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signup = findViewById(R.id.btnsignup);
        email = findViewById(R.id.etemail);
        password= findViewById(R.id.etpassword);

        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String username = email.getText().toString();
                String pass = password.getText().toString();
                SharedPreferences sp = getSharedPreferences("files", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("email",username);
                ed.putString("password",pass);
                ed.apply();
                Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);

            }
        });

    }
}
