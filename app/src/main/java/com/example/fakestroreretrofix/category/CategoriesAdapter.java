package com.example.fakestroreretrofix.category;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.CategoryItemBinding;
import com.example.fakestroreretrofix.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<Product> products;

    private OnCategoryActionListener listener;

    void setListener(OnCategoryActionListener listener){
        this.listener = listener;
    }

    public CategoriesAdapter(List<Product> products){
        this.products = products;
    }

    void  setData(List<Product> categories){
        this.products = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CategoryItemBinding binding = CategoryItemBinding.inflate(layoutInflater,parent,false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Product product = products.get(position);
        holder.binding.categoriesTxt.setText(product.getName());
//        holder.binding.categoriesTxt.setOnClickListener(v -> {
//            listener.onItemClicked(product);
//        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
