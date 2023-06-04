package com.example.fakestroreretrofix.network;

import com.example.fakestroreretrofix.model.Cart;
import com.example.fakestroreretrofix.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET("api/v1/categories")
    Call<List<Product>> fetchCategories();

//    @GET("products/category/{categoryName}")
//    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);
//
//    @GET("products/{productId}")
//    Call<Product> getProductDetails(@Path("productId") int productId);
//
//    @GET("carts/{cartId}")
//    Call<Cart> getCartItems(@Path("cartId") int CartId);
}
