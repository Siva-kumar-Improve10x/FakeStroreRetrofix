//package com.example.fakestroreretrofix;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//
//import com.example.fakestroreretrofix.category.CategoriesActivity;
//import com.example.fakestroreretrofix.databinding.ActivitySplashBinding;
//
//public class SplashActivity extends AppCompatActivity {
//    private ActivitySplashBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivitySplashBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        getSupportActionBar().hide();
//        Handler handler = new Handler();
//        handler.postDelayed(() -> {
//            Intent intent = new Intent(this, CategoriesActivity.class);
//            startActivity(intent);
//        },2000);
//    }
//}