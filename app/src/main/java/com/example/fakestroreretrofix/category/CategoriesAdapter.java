package com.example.fakestroreretrofix.category;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.CategoryItemBinding;

import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<String> categories;

    private OnCategoryActionListener listener;

    void setListener(OnCategoryActionListener listener){
        this.listener = listener;
    }

    public CategoriesAdapter(List<String> categories){
        this.categories = categories;
    }

    void  setData(List<String> categories){
        this.categories = categories;
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
        String category = categories.get(position);
        holder.binding.categoriesTxt.setText(category);
        holder.binding.categoriesTxt.setOnClickListener(v -> {
            listener.onItemClicked(category);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
