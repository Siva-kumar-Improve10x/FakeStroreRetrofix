package com.example.fakestroreretrofix.products;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestroreretrofix.databinding.ActivityProductsBinding;
import com.example.fakestroreretrofix.productdetails.BaseActivity;
import com.example.fakestroreretrofix.productdetails.ProductDetailsActivity;
import com.example.fakestroreretrofix.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity implements OnItemActionListener {

    private ActivityProductsBinding binding;
    private ProductsAdapter adapter;

    private  String category;
    private  List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("products");
        actionBar.setDisplayHomeAsUpEnabled(true);
        setupAdapter();
        connectAdapter();
    }

    private void connectAdapter() {
        binding.productRv.setLayoutManager(new GridLayoutManager(this,2));
        binding.productRv.setAdapter(adapter);
    }

    private void setupAdapter() {
        adapter = new ProductsAdapter(products);
        adapter.setOnAction(this);
    }

    private void fetchProducts(String category) {
        Call<List<Product>> call = service.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                adapter.updateData(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClicked(int productId) {
        Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
        intent.putExtra("productId", productId);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchProducts(category);
    }
}