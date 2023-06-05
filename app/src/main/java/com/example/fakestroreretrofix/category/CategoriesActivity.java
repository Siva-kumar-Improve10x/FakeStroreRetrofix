package com.example.fakestroreretrofix.category;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestroreretrofix.model.Product;
import com.example.fakestroreretrofix.productdetails.BaseActivity;
import com.example.fakestroreretrofix.databinding.ActivityCategoriesBinding;
import com.example.fakestroreretrofix.products.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity implements OnCategoryActionListener {
    private ActivityCategoriesBinding binding;
    private ArrayList<Product> categories = new ArrayList<>();
    private CategoriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        getApi();
        setUpAdapter();
        connectAdapter();
    }

    private void getApi() {
        Call<List<Product>> call = service.fetchCategories();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(adapter);
    }

    private void setUpAdapter() {
        adapter = new CategoriesAdapter(categories);
        adapter.setListener(this);
    }

    @Override
    public void onItemClicked(Product product) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}