package com.example.fakestroreretrofix;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.CategoryItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    CategoryItemBinding binding;
    public CategoryViewHolder(CategoryItemBinding categoryitemBinding) {
        super(categoryitemBinding.getRoot());
        binding = categoryitemBinding;
    }
}
