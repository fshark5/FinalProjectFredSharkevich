package com.example.homework;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://zillow56.p.rapidapi.com/search?location="; //King%20County%2C%20WA

    // Singleton pattern
    public static Retrofit getRetrofitInstance(String theLocation) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL + "" + theLocation )
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
