package com.example.fakestroreretrofix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestroreretrofix.databinding.ActivityCategoriesBinding;
import com.example.fakestroreretrofix.network.FakeApi;
import com.example.fakestroreretrofix.network.FakeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity implements OnCategoryActionListener {
    private ActivityCategoriesBinding binding;
    private ArrayList<String> categories = new ArrayList<>();
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
        FakeApiService service = new FakeApi().fakeApiService();
        Call<List<String>> call = service.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
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
    public void onItemClicked(String categoryName) {
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("category",categoryName);
        startActivity(intent);
    }
}