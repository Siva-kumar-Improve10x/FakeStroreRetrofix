package com.example.fakestroreretrofix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestroreretrofix.databinding.ActivityCategoryBinding;
import com.example.fakestroreretrofix.network.FakeApi;
import com.example.fakestroreretrofix.network.FakeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity implements CategoryViewHolder.OnServiceActionListener {
    ActivityCategoryBinding binding;
    private ArrayList<String> categories = new ArrayList<>(); //Todo
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        getApi();
        setUpAdapter();
        connectAdapter();
    }

    private void getApi() {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<List<String>> call = service.fetchCategory();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Toast.makeText(CategoryActivity.this, "Success", Toast.LENGTH_SHORT).show();
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void connectAdapter() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(adapter);

    }

    private void setUpAdapter() {
        adapter = new CategoryAdapter(categories);
        adapter.setListener(this);
    }

    @Override
    public void onItemClicked(String categoryName) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("category",categoryName);
        startActivity(intent);
    }
}