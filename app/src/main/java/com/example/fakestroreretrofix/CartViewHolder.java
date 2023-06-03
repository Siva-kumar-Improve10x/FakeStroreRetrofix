package com.example.fakestroreretrofix;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.CartItemBinding;

public class CartViewHolder extends RecyclerView.ViewHolder {

    CartItemBinding binding;
    public CartViewHolder(CartItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
