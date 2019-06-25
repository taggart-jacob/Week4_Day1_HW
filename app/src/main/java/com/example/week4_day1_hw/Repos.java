package com.example.week4_day1_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.week4_day1_hw.model.datasource.RepoObjectAsyncTask;
import com.example.week4_day1_hw.model.gitprofile.RepoObject;

import java.util.ArrayList;

public class Repos extends AppCompatActivity implements RepoObjectAsyncTask.AsyncCallback {

    RecyclerView repoRecycler;
    //RecyclerViewAdapter repoRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG","what up dude");
        super.onCreate(savedInstanceState);
        repoRecycler = findViewById(R.id.rvRepoRecyclerView);
        setContentView(R.layout.activity_repos);
        Log.d("TAG","what up dude");
        RepoObjectAsyncTask asyncTask = new RepoObjectAsyncTask(this);
        asyncTask.execute("string");
        /*
        repoRecyclerAdapter = new RecyclerViewAdapter(listOfRepos());*/


    }

    /*private ArrayList<RepoObject> listOfRepos() {
        ArrayList<RepoObject> repoObjectArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            RepoObject repo = new RepoObject();
        }
        return repoObjectArrayList;
    }*/

    public void onClick(View view) {
    }

    @Override
    public void returnString(String name, String user, String language) {

    }
}
