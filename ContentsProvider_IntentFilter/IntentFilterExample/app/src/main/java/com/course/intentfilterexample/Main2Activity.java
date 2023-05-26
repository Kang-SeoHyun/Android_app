package com.course.intentfilterexample;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView myText =
                (TextView)findViewById(R.id.textView2);
        Uri uri = getIntent().getData();
        myText.setText(uri.toString() + " is accepted.");
    }
}
