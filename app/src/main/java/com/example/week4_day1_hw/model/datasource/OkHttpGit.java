package com.example.week4_day1_hw.model.datasource;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpGit {
    public void getAsyncResponse() {

        //in case I want to use the async response for okhttp
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient returnClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        Request req = new Request.Builder().url("https://api.github.com/users/taggart-jacob").build();
        returnClient.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("TAG", response.body().string());
            }
        });
    }

    public void getSyncResponse() {
        OkHttpClient returnClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("https://api.github.com/users/taggart-jacob").build();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = returnClient.newCall(request).execute();
                    Log.d("TAG", response.body().string());
                } catch (Exception e) {

                }
            }
        });
        thread.start();
    }
}
