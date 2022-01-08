package com.example.class_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EnterPhoneActivity extends AppCompatActivity {
    Button send;
    TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send=findViewById(R.id.btnsend);
        phone=findViewById(R.id.phone);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = phone.getText().toString();
                Intent i = new Intent(EnterPhoneActivity.this,MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("value",value);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
