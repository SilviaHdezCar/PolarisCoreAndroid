package com.example.wposs_user.polariscoreandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void menu(View v){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
