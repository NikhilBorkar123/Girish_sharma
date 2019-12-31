package com.example.abc.girishsharma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElectricityWatersupply extends AppCompatActivity {
    EditText title, description, address;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_watersupply);
        findviews();
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getData();
                submitForm();
            }
        });
    }
    private void findviews() {
        title = findViewById(R.id.editTitle);
        description = findViewById(R.id.editDescription);
        address = findViewById(R.id.editAddress);
    }

    private void getData() {
        s1 = "2";
        s2 = "2";
        s3 = "50";
        s4 = "1";
        s5 = "test";
        s6 = "test";
        s7 = title.getText().toString();
        s8 = description.getText().toString();
        s9 = address.getText().toString();
        s10 = "Electricity and Water supply";
    }

    private void submitForm() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> call = apiInterface.postIssue(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
        Log.e("post Issue call:", "" + call);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject postIssue = response.body();
                Log.e("Post Issue res", postIssue + "");
                String success_message = postIssue.get("success").getAsString();
                Log.e("the success message is", success_message + "");
//                ImageView loading=view.findViewById(R.id.imageView9);
                if (postIssue != null) {
                    if (success_message.equals("true")) {
//                        animationDrawable.stop();
//                        loading.setVisibility(View.INVISIBLE);
                        Toast.makeText(ElectricityWatersupply.this, "Submit data successfully...", Toast.LENGTH_SHORT).show();
                        new AlertDialog.Builder(ElectricityWatersupply.this)
                                .setTitle("You successfully raised your Issue!")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                                    }
                                })
                                .show();
                    } else {
//                        animationDrawable.stop();
//                        loading.setVisibility(View.INVISIBLE);
                        Toast.makeText(ElectricityWatersupply.this, "Something went wrong in submitting...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    assert postIssue != null;
                    Log.v("Response error", postIssue.toString());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(ElectricityWatersupply.this, "failure", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}
