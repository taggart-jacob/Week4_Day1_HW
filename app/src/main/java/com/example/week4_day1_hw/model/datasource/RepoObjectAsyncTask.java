package com.example.week4_day1_hw.model.datasource;

import android.os.AsyncTask;
import android.util.Log;

import com.example.week4_day1_hw.model.gitprofile.Owner;
import com.example.week4_day1_hw.model.gitprofile.ProfileGit;
import com.example.week4_day1_hw.model.gitprofile.RepoObject;
import com.google.gson.Gson;

import java.util.ArrayList;

public class RepoObjectAsyncTask extends AsyncTask<String, String, RepoObject> {
    AsyncCallback asyncCallback;
    public RepoObjectAsyncTask(RepoObjectAsyncTask.AsyncCallback asyncCallback) {
        this.asyncCallback = asyncCallback;
    }

    @Override
    protected RepoObject doInBackground(String... strings) {
        HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
        String responseFromRepoObject = httpUrlConnection.getJsonFromRepoObject();
        Gson gson = new Gson();
        RepoObject response = gson.fromJson(responseFromRepoObject, RepoObject.class);
        return response;
    }

    @Override
    protected void onPostExecute(RepoObject repoObject) {
        super.onPostExecute(repoObject);

        String repoName = repoObject.getName();
        String repoUser = repoObject.getOwner().getLogin();
        String repoLanguage = repoObject.getLanguage();
        Log.d("TAG", repoName + "\n" + repoUser + "\n" + repoLanguage);
        asyncCallback.returnString(repoName, repoName, repoLanguage);
    }

    public interface AsyncCallback{
        void returnString(String name, String user, String language);
    }
}
