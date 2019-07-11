package com.example.abc.girishsharma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;


public class NewIssues extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5,c6;
    TextView head1,head2,head3,head4,head5,head6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_issues);

        c1 = findViewById(R.id.str);
        c2 = findViewById(R.id.pol);
        c3 = findViewById(R.id.ew);
        c4 = findViewById(R.id.pt);
        c5 = findViewById(R.id.trs);
        c6 = findViewById(R.id.rfm);
        head1 = findViewById(R.id.stray);
        head2 = findViewById(R.id.poll);
        head3 = findViewById(R.id.ele);
        head4 = findViewById(R.id.pub);
        head5 = findViewById(R.id.road);
        head6 = findViewById(R.id.footpath);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = head1.getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewIssuesForm.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = head2.getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewIssuesForm.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = head3.getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewIssuesForm.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = head4.getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewIssuesForm.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = head5.getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewIssuesForm.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = head6.getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewIssuesForm.class);
                intent.putExtra("message", str);
                startActivity(intent);
            }
        });
    }
}
