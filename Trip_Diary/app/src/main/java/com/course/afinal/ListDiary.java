package com.course.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListDiary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_diary);
    }

    public void onButtonClicked(View v) {

        Intent intent = new Intent(getApplicationContext(),jeju.class);
        startActivity(intent);
    }
}