package com.course.activityexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String message = "Android App Message : ";
    TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(message, " onCreate() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("onCreate !!!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(message, " onStart() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("onStart !!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(message, " onResume() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("onResume !!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(message, " onPause() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("onPause !!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(message, " onStop() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("onStop !!!");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(message, " onDestroy() operated!!");
        text = (TextView)findViewById(R.id.textView);
        text.setText("onDestroy !!!");
    }
}