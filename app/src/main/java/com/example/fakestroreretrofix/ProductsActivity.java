package com.example.fakestroreretrofix;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestroreretrofix.databinding.ActivityProductsBinding;
import com.example.fakestroreretrofix.model.Product;
import com.example.fakestroreretrofix.network.FakeApi;
import com.example.fakestroreretrofix.network.FakeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity implements OnItemActionListenser {

    ActivityProductsBinding binding;
    private  ProductAdapter adapter;


    private  List<Product> products = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("products");
        actionBar.setDisplayHomeAsUpEnabled(true);
        fetchProducts(category);
        setupAdapter();
        connectAdapter();
    }

    private void connectAdapter() {
        binding.productRv.setLayoutManager(new GridLayoutManager(this,2));
        binding.productRv.setAdapter(adapter);

    }

    private void setupAdapter() {
        adapter = new ProductAdapter(products);
        adapter.setonAction(this);
    }

    private void fetchProducts(String category) {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<List<Product>> call = service.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Toast.makeText(ProductsActivity.this, "Success", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(getApplicationContext(),ProductItemActivity.class);
        intent.putExtra("category", productId);
        startActivity(intent);
    }
}