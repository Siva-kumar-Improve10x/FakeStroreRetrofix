package com.example.fakestroreretrofix.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakestroreretrofix.databinding.ProductItemBinding;
import com.example.fakestroreretrofix.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Product> products;
     public OnItemActionListener itemClickListener;

     void setOnAction(OnItemActionListener itemClickListener){
         this.itemClickListener = itemClickListener;
     }
    void updateData(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public ProductsAdapter(List<Product> products) {
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
        holder.binding.ruppeeTxt.setText("₹" + String.valueOf(product.getPrice()));
//        holder.binding.ratingTxt.setText(String.valueOf(product.getRating().getRate()));
//        holder.binding.ratingbarRb.setRating(product.getRating().getRate());
//        holder.binding.countTxt.setText("(" + String.valueOf(product.getRating().getCount()) + ")");
        Picasso.get().load(product.getImageUrls().get(0)).into(holder.binding.productIv);
        holder.binding.getRoot().setOnClickListener(v -> {
            itemClickListener.onClicked(product.getId());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
