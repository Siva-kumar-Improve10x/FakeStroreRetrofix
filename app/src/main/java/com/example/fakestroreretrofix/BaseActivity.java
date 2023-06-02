package com.example.fakestroreretrofix;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fakestroreretrofix.network.FakeApi;
import com.example.fakestroreretrofix.network.FakeApiService;

public class BaseActivity extends AppCompatActivity {

    protected FakeApiService service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFakeApi();
    }

    private void createFakeApi(){
        service = new FakeApi().fakeApiService();
    }
}
