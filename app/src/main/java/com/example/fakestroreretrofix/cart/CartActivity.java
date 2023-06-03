package com.example.fakestroreretrofix.cart;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestroreretrofix.databinding.ActivityCartBinding;
import com.example.fakestroreretrofix.model.Cart;
import com.example.fakestroreretrofix.model.CartProduct;
import com.example.fakestroreretrofix.productdetails.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends BaseActivity {

    private List<CartProduct> cartProducts = new ArrayList<>();

    private CartAdapter adapter;
    private ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Final Cart");
        setupAdapter();
        connectAdapter();
        getApi(1);
    }

    private void getApi(int cartId) {
        Call<Cart> call = service.getCartItems(cartId);
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                Toast.makeText(CartActivity.this, "success" + response.body(), Toast.LENGTH_SHORT).show();
                adapter.update(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Toast.makeText(CartActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        binding.cartRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cartRv.setAdapter(adapter);
    }

    private void setupAdapter() {
        adapter = new CartAdapter(cartProducts);
    }

}

