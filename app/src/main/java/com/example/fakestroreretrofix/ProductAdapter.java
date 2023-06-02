package com.example.fakestroreretrofix;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.ProductItemBinding;
import com.example.fakestroreretrofix.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Product> products;
     public OnItemActionListenser itemClickListener;

     void setonAction(OnItemActionListenser itemClickListener){
         this.itemClickListener = itemClickListener;
     }
    void updateData(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductItemBinding binding = ProductItemBinding.inflate(inflater, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.binding.productnameTxt.setText(product.getTitle());
        holder.binding.ruppeeTxt.setText("₹"+String.valueOf(product.getPrice()));
        holder.binding.ratingTxt.setText(String.valueOf(product.getRating().getRate()));
        holder.binding.ratingbarRb.setRating(product.getRating().getRate());
        holder.binding.countTxt.setText("("+String.valueOf(product.getRating().getCount())+")");
        holder.binding.getRoot().setOnClickListener(v -> {
            itemClickListener.onClicked(products.get(position).getId());
        });
        Picasso.get().load(product.getImage()).into(holder.binding.productIv);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
