package com.example.Assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button signup,login;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkLoginStatus();

        signup = findViewById(R.id.btnsignup);
        login=findViewById(R.id.btnlogin);
        email=findViewById(R.id.etemail);
        password= findViewById(R.id.etpassword);

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                SharedPreferences sp = getSharedPreferences("files", Context.MODE_PRIVATE);
                String femail = sp.getString("email","prabesh");
                String fpassword = sp.getString("password","prabesh");
                String uemail = email.getText().toString();
                String upassword = password.getText().toString();

                if(femail.equals(uemail)&&fpassword.equals(upassword)){

                    Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_LONG).show();

                    SharedPreferences lp = getSharedPreferences("state",MODE_PRIVATE);
                    SharedPreferences.Editor et = lp.edit();
                    et.putBoolean("loginstate",true);
                    et.apply();
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(MainActivity.this,"Incorrect Email or Password",Toast.LENGTH_LONG).show();
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
    
    private void checkLoginStatus() {
        SharedPreferences sp = getSharedPreferences("state", MODE_PRIVATE);
        boolean state = sp.getBoolean("loginstate",false);
        if(state){
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        }
    }

}