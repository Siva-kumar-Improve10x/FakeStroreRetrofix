package com.example.fakestroreretrofix.network;

import com.example.fakestroreretrofix.Cart;
import com.example.fakestroreretrofix.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET("products/categories")
    Call<List<String>> fetchCategories();

    @GET("products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET("products/{productId}")
    Call<Product> getProductDetails(@Path("productId") int productId);

    @GET("carts/{cartId}")
    Call<Cart> getCartItems(@Path("cartId") int CartId);
}
