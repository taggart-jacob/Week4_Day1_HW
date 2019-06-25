package com.example.week4_day1_hw.model.datasource;

import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.week4_day1_hw.model.gitprofile.ProfileGit;
import com.google.gson.Gson;

public class ProfileGitAsyncTask extends AsyncTask<String, String, ProfileGit> {

    AsyncCallback asyncCallback;

    public ProfileGitAsyncTask(ProfileGitAsyncTask.AsyncCallback asyncCallback) {
        this.asyncCallback = asyncCallback;
    }


    @Override
    protected ProfileGit doInBackground(String... strings) {
        HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
        String responseFromProfileGit = httpUrlConnection.getJsonFromGitProfile();
        Log.d("TAG", "here!");
        Gson gson = new Gson();
        ProfileGit response = gson.fromJson(responseFromProfileGit, ProfileGit.class);
        return response;
    }

    @Override
    protected void onPostExecute(ProfileGit profileGit) {
        super.onPostExecute(profileGit);

        String userName = profileGit.getLogin();
        String userBio = profileGit.getBio();
        String userCompany = profileGit.getCompany();
        String userLocation = profileGit.getLocation();

        Log.d("TAG", userName + "\n" + userBio + "\n" + userCompany + "\n" + userLocation);

        asyncCallback.returnString(userName, userBio, userCompany, userLocation);
    }

    public interface AsyncCallback{
        void returnString(String user, String bio, String company, String location);
    }
}
