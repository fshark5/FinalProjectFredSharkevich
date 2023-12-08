package com.example.homework;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetDataService {
    @Headers("X-RapidAPI-Key: cfc28f84b9mshf414f934dc9b9f4p15016ajsn4414cdc0892a")
    @GET("/homes")
    Call<List<HomeData>> getAllHomes();


}
