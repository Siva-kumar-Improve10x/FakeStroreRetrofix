package com.example.fakestroreretrofix.productdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fakestroreretrofix.cart.CartActivity;
import com.example.fakestroreretrofix.R;
import com.example.fakestroreretrofix.network.FakeApi;
import com.example.fakestroreretrofix.network.FakeApiService;

public class BaseActivity extends AppCompatActivity {

    protected FakeApiService service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFakeApi();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.cart_item_i) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void createFakeApi(){
        service = new FakeApi().fakeApiService();
    }
}
