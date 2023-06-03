package com.example.fakestroreretrofix;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.fakestroreretrofix.model.Product;
import com.example.fakestroreretrofix.network.FakeApi;
import com.example.fakestroreretrofix.network.FakeApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCategoryName() throws IOException {
        FakeApiService fakeApiService = new FakeApi().fakeApiService();
        Call<List<String>> call = fakeApiService.fetchCategories();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public void getProducts() throws IOException {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<List<Product>> call = service.fetchProducts("electronics");
        List<Product> products = call.execute().body();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }

    @Test
    public void getProductItem() throws IOException {
        FakeApiService service =  new FakeApi().fakeApiService();
        Call<Product> call = service.getProductDetails(7);
        Product product = call.execute().body();
        assertNotNull(product);
        System.out.println(new Gson().toJson(product));
    }

    @Test
    public void getCartItem() throws IOException {
        FakeApiService service = new FakeApi().fakeApiService();
        Call<Cart> call = service.getCartItems(1);
        Cart cart = call.execute().body();
        assertNotNull(cart);
        System.out.println(new Gson().toJson(cart));
    }
}