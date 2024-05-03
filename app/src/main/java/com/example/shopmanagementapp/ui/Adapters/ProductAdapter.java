package com.example.shopmanagementapp.ui.Adapters;

import com.example.shopmanagementapp.R;
import com.example.shopmanagementapp.ui.Elements.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Context mContext;
    private List<Product> mProductList;

    public ProductAdapter(@NonNull Context context, @NonNull List<Product> productList) {
        super(context, 0, productList);
        mContext = context;
        mProductList = productList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item_product_cardview, parent, false);
        }

        Product currentProduct = mProductList.get(position);

        TextView textViewName = listItem.findViewById(R.id.editTextName);
        textViewName.setText(currentProduct.getName());

        TextView textViewPrice = listItem.findViewById(R.id.editTextPrice);
        textViewPrice.setText(String.valueOf(currentProduct.getPrice()));

        TextView textViewQuantity = listItem.findViewById(R.id.editTextQuantity);
        textViewQuantity.setText(String.valueOf(currentProduct.getQuantityInt()));

        TextView textViewId = listItem.findViewById(R.id.editTextId);
        textViewId.setText(currentProduct.getId());

        TextView textViewDescription = listItem.findViewById(R.id.editTextDescription);
        textViewDescription.setText(currentProduct.getDescription());

        TextView textViewWeight = listItem.findViewById(R.id.editTextWeight);
        textViewWeight.setText(String.valueOf(currentProduct.getWeight()));

        TextView textViewTotalPrice = listItem.findViewById(R.id.editTextPrice);
        textViewTotalPrice.setText(String.valueOf(currentProduct.getPrice()));

        return listItem;
    }
}
