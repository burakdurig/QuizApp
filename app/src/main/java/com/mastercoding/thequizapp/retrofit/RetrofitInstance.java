package com.mastercoding.thequizapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    String BASE_URL = "http://10.0.2.2/quiz/";

    // Create adn Return a configured Retrofit Instance
    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
