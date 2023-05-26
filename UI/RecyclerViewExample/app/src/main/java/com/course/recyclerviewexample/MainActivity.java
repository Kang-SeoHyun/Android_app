package com.course.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        ArrayList<School> schoolsInfo = new ArrayList<>();

        schoolsInfo.add(new School(R.drawable.dongguk,"동국대학교",
            "http://www.dongguk.edu/mbs/kr/index.jsp"));
        schoolsInfo.add(new School(R.drawable.snu, "서울대학교",
            "http://www.snu.ac.kr/index.html"));
        schoolsInfo.add(new School(R.drawable.yonsei,"연세대학교",
            "https://www.yonsei.ac.kr/sc/"));
        schoolsInfo.add(new School(R.drawable.korea,"고려대학교",
            "http://www.korea.ac.kr/"));

        MyAdapter myAdapter = new MyAdapter(schoolsInfo);
        myRecyclerView.setAdapter(myAdapter);


    }

}