package com.example.fakestroreretrofix;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.ProductItemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ProductItemBinding binding;

    public ProductViewHolder(ProductItemBinding productItemBinding){
        super(productItemBinding.getRoot());
        binding = productItemBinding;
    }
}
