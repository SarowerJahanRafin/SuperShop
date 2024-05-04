package com.example.auctionapp;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserWonItemAdapter extends RecyclerView.Adapter<UserWonItemAdapter.ItemViewHolder> {
    private List<Item> itemList;

    public UserWonItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
        notifyItemInserted(itemList.size() - 1);
    }

    // Method to update item price
    public void updateItemPrice(String itemKey, double newPrice) {
        // Iterate through itemList to find the item with the specified key
        for (Item item : itemList) {
            if (item.getItemKey().equals(itemKey)) {
                // Update the item's price
                item.setCurrentPrice(newPrice);
                // Notify adapter that the item has changed
                notifyDataSetChanged();
                break; // Exit loop once item is found and updated
            }
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.won_item_list_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName;
        private TextView itemDescription;
        private TextView itemPrice;
        private TextView sellerName;
        private TextView sellerEmail;
        private TextView totalAmount ;
        private TextView soldTime;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
//            itemDescription = itemView.findViewById(R.id.item_description);
            itemPrice = itemView.findViewById(R.id.item_price);
            sellerName = itemView.findViewById(R.id.sellerName);
            sellerEmail = itemView.findViewById(R.id.sellerEmail);
            totalAmount = itemView.findViewById(R.id.productTotalAmount);
            soldTime = itemView.findViewById(R.id.productSoldTime);

            ConstraintLayout wonCardView = itemView.findViewById(R.id.wonCardView);
            wonCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String SellerEmail = sellerEmail.getText().toString();
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:"+SellerEmail));
                    view.getContext().startActivity(emailIntent);

                }
            });
        }

        public void bind(Item item) {
            itemName.setText(item.getName());
//            itemDescription.setText(item.getDescription());
            itemPrice.setText(String.valueOf(item.getCurrentAmount()));
            sellerName.setText(item.customerName);
            double soldAmount = item.totalAmountSold / item.getCurrentAmount();
            sellerEmail.setText(soldAmount + ""); // it would represent the total sold amount , neither the email or the price
            totalAmount.setText(item.totalAmountSold + "");
            soldTime.setText(item.SoldDateTime  );

        }

    }
}
