package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerActivity extends AppCompatActivity {

    private HomeAdapter adapter;
    private RecyclerView homeList;
    //ProgressDialog progressDialog;
    private String location;

    private HomeData homeData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent navIntent = getIntent();
        location = navIntent.getStringExtra("location");

//        progressDoalog = new ProgressDialog(RecyclerActivity.this);
//        progressDoalog.setMessage("Loading....");
//        progressDoalog.show();

        // Create a reference for the RetrofitInstance interface
        GetDataService service = RetrofitClientInstance.getRetrofitInstance(location).create(GetDataService.class);

        Call<List<HomeData>> call = service.getAllHomes();
        call.enqueue(new Callback<List<HomeData>>() {
            @Override
            public void onResponse(Call<List<HomeData>> call, Response<List<HomeData>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<HomeData>> call, Throwable t) {
                Toast.makeText(RecyclerActivity.this,
                        "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void generateDataList(List<HomeData> photoList) {
        homeList = findViewById(R.id.homeRecyclerView);
        adapter = new HomeAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerActivity.this);
        homeList.setLayoutManager(layoutManager);
        homeList.setAdapter(adapter);
    }

}