package com.example.fakestroreretrofix.network;

import com.example.fakestroreretrofix.model.Cart;
import com.example.fakestroreretrofix.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FakeApiService {

    @GET("api/v1/categories")
    Call<List<Product>> fetchCategories();

    @GET("/api/v1/products/")
    Call<List<Product>> fetchProducts(@Query("categoryId") int categoryId);

    @GET("api/v1/products/{productId}")
    Call<Product> fetchProductDetails(@Path("productId") int productId);

//    @GET("carts/{cartId}")
//    Call<Cart> getCartItems(@Path("cartId") int CartId);
}

