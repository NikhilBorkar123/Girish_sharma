package com.example.abc.girishsharma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class NewIssuesForm extends AppCompatActivity {
    TextView top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_issues_form);


        top = findViewById(R.id.mainHead);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        top.setText(str);



    }
}
