package com.example.Assignment_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rv;
    private Button btn;

    private String[] names ={"Albish","Prabesh","Sandesh","Dipesh",
            "Om","Saroj","Sunil","Sagun"};
    private String[] address ={"Kathmandu","Kathmandu","Kathmandu","Kathmandu",
            "Kathmandu","Kathmandu","Kathmandu","Kathmandu"};
    private String[] faculty ={"BCA","BCA","BCA","BCA","BCA","BCA","BCA","BCA"};
    private String[] semester ={"6th","6th","6th","6th","6th","6th","6th","6th"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn = findViewById(R.id.btn);

        rv= findViewById(R.id.rv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rv.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
                rv.setAdapter(new CustomAdapter(HomeActivity.this, names, address, faculty ,semester));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.logout){
            SharedPreferences sp = getSharedPreferences("state",MODE_PRIVATE);
            SharedPreferences.Editor et = sp.edit();
            et.putBoolean("loginstate",false);
            et.apply();
            Intent i = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(i);

        }
        return true;
    }
}