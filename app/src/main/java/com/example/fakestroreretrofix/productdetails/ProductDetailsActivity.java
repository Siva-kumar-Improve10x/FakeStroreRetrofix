package com.example.fakestroreretrofix.productdetails;

import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fakestroreretrofix.databinding.ActivityProductDetailsBinding;
import com.example.fakestroreretrofix.model.Product;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {

    private ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int id = intent.getIntExtra("productId", 0);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Product Details");
        actionBar.setDisplayHomeAsUpEnabled(true);
        fetchProductDetails(id);
    }

    private void fetchProductDetails(int productId) {
        Call<Product> call = service.fetchProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();
                binding.pnameTxt.setText(product.getTitle());
                binding.pdiscriptionTxt.setText(product.getDescription());
                binding.prateTxt.setText("₹ " + String.valueOf(product.getPrice()));
//                binding.pcountTxt.setText("(" + String.valueOf(product.getRating().getCount()) + ")");
//                binding.pratingBarRv.getRating();
                Picasso.get().load(product.getImageUrls().get(0)).into(binding.pimageIv);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "Failed To Load", Toast.LENGTH_SHORT).show();
            }
        });
    }
}