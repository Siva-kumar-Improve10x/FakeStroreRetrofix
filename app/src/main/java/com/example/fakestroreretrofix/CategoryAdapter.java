package com.example.fakestroreretrofix;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.CategoryItemBinding;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<String> categories; //Todo

    private CategoryViewHolder.OnServiceActionListener listener;

    void setListener(CategoryViewHolder.OnServiceActionListener listener){
        this.listener = listener;
    }

    public CategoryAdapter(List<String> categories){
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
        String category = categories.get(position); //Todo
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
