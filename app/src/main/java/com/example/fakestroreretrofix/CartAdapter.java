package com.example.fakestroreretrofix;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.CartItemBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {


    private List<CartProduct> cartProducts;

    public CartAdapter(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;

    }

    void update(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CartItemBinding binding = CartItemBinding.inflate(inflater, parent, false);
        CartViewHolder viewHolder = new CartViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartProduct cartProduct = cartProducts.get(position);
        holder.binding.itemidTxt.setText(String.valueOf(cartProduct.getProductId()));
        holder.binding.countnumTxt.setText(String.valueOf(cartProduct.getQuantity()));
        if (cartProduct.getQuantity() == 0) {
            holder.binding.minusBtn.setVisibility(View.GONE);
            holder.binding.countnumTxt.setVisibility(View.GONE);
        } else {
            holder.binding.countnumTxt.setText(cartProduct.getQuantity()+"");             
            holder.binding.minusBtn.setVisibility(View.VISIBLE);
            holder.binding.countnumTxt.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
