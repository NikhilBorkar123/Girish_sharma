package com.example.abc.girishsharma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class NewIssues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_issues);
        CardView cardView;
        cardView = findViewById(R.id.cardView1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewIssues.this,StrayAnimal.class);
                startActivity(intent);
            }
        });
        cardView = findViewById(R.id.cardView2);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewIssues.this,Pollution.class);
                startActivity(intent);
            }
        });
        cardView = findViewById(R.id.cardView3);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewIssues.this,ElectricityWatersupply.class);
                startActivity(intent);
            }
        });
        cardView = findViewById(R.id.cardView4);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewIssues.this,PublicTransport.class);
                startActivity(intent);
            }
        });
        cardView = findViewById(R.id.cardView5);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewIssues.this,TrafficRoadsafety.class);
                startActivity(intent);
            }
        });
        cardView = findViewById(R.id.cardView6);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewIssues.this,RoadFootpath.class);
                startActivity(intent);
            }
        });
    }
}