package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.mtp.MtpObjectInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;


public class MainActivity extends AppCompatActivity {

    AwesomeValidation awesomeValidation = null;
    private EditText Name;
    private EditText Mobile_no;
    private EditText Email;
    private Button Update_Info;
    private Button Logout;
    TextView Fpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*AwesomeValidation mAwesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        Name=(EditText)findViewById(R.id.edtname);
        Mobile_no=(EditText)findViewById(R.id.edtContact);
        Email=(EditText)findViewById(R.id.edtEmail);
        Update_Info=(Button)findViewById(R.id.btnupdate_info);*/
        Logout = (Button) findViewById(R.id.btnLogout);
        Fpass=(TextView)findViewById(R.id.upass);
        Fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this,Password.class);
                startActivity(intent1);
                finish();
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();

            }


        });




        /*Update_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                awesomeValidation.addValidation(MainActivity.this, R.id.edtname, "[a-zA-Z\\s]+", R.string.error);

                // awesomeValidation.addValidation(MainActivity.this, R.id.edtContact, "[0-9\\s]+", R.string.error);
              // awesomeValidation.addValidation(MainActivity, R.id.edtEmail, android.util.Patterns.EMAIL_ADDRESS, R.string.error);



                if(awesomeValidation.validate()) {
                    validate();
                }
            }
        });
    }

    private void validate(){


    }
    private void move(){
        Intent intent = new Intent(MainActivity(logout).this,SecondActivity.class);
    }*/
    }
}
