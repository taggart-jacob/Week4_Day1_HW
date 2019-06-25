package com.example.week4_day1_hw.model.datasource;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUrlConnection {
    //JSON for Profile properties
    public String getJsonFromGitProfile(){
        String jsonResult = "";
        HttpURLConnection httpUrlConnection = null;
        try {
            URL profileURL = new URL("https://api.github.com/users/taggart-jacob");
            httpUrlConnection = (HttpURLConnection)profileURL.openConnection();
            InputStream inputStream = httpUrlConnection.getInputStream();
            Log.d("TAG", "HERE!");

            int currentCharAsciiValue = inputStream.read();
            while (currentCharAsciiValue != -1){
                char currentChar = (char) currentCharAsciiValue;
                currentCharAsciiValue = inputStream.read();
                jsonResult = jsonResult + currentChar;
            }

        } catch (Exception e) {
            Log.e("TAG", "ERROR IN HTTPURLCONNECTION - ", e);
        } finally { //finally does block of code no matter what
            if (httpUrlConnection != null){
                httpUrlConnection.disconnect();
            }
        }
        return jsonResult;
    }

    //getting the JSON for the repos
    public String getJsonFromRepoObject(){
        String jsonResult = "";
        HttpURLConnection httpUrlConnection = null;

        try{
            URL reposURL = new URL("https://api.github.com/users/taggart-jacob/repos");
            httpUrlConnection = (HttpURLConnection)reposURL.openConnection();
            InputStream inputStream = httpUrlConnection.getInputStream();
            Log.d("TAG", "HERE");
            int currentCharAscii = inputStream.read();
            while (currentCharAscii != -1){
                char currentChar = (char) currentCharAscii;
                currentCharAscii = inputStream.read();
                jsonResult = jsonResult + currentChar;

            }

        } catch (Exception e){
            Log.e("TAG", "ERROR IN HTTPURLCONNECTION - ", e);
        } finally {
            if (httpUrlConnection != null){
                httpUrlConnection.disconnect();
            }
        }
        return jsonResult;
    }
}
