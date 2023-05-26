package com.course.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDiaryButtonClicked(View v) {

        Intent intent = new Intent(getApplicationContext(),diary.class);
        startActivity(intent);
    }

    public void onListButtonClicked(View v) {

        Intent intent = new Intent(getApplicationContext(),ListDiary.class);
        startActivity(intent);
    }
}