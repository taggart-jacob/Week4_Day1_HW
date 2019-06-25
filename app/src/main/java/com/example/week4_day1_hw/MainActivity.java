package com.example.week4_day1_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.week4_day1_hw.model.datasource.ProfileGitAsyncTask;

public class MainActivity extends AppCompatActivity implements ProfileGitAsyncTask.AsyncCallback {
    TextView tvUserName;
    TextView tvUserBio;
    TextView tvUserCompany;
    TextView tvUserLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUserName = findViewById(R.id.tvUserName);
        tvUserBio = findViewById(R.id.tvUserBio);
        tvUserCompany = findViewById(R.id.tvUserCompany);
        tvUserLocation = findViewById(R.id.tvUserLocation);

        ProfileGitAsyncTask asyncTask = new ProfileGitAsyncTask(this);
        asyncTask.execute();


    }

    @Override
    public void returnString(String user, String bio, String company, String location) {
        tvUserName.setText("User Name: " + user);
        tvUserBio.setText("User Bio: " + bio);
        tvUserCompany.setText("Company: " + company);
        tvUserLocation.setText("Location: " + location);
    }

    public void onClick(View view) {
        startActivity(new Intent(view.getContext(), Repos.class));
    }
}
