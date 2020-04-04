package com.example.quinch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.view.Window;
//import android.widget.Toolbar;

public class help extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar=(Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    public void about (View view)
    {
        Intent intent=new Intent(this, about.class);
        startActivity(intent);
    }
    public void onBackPressed()
    {
        Intent gohome=new Intent(this, MainActivity.class);
        startActivity(gohome);
    }
}
