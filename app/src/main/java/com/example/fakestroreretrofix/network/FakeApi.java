package com.example.fakestroreretrofix.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FakeApi {
    public FakeApiService fakeApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(FakeApiService.class);
    }
}
