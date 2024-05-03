package com.example.shopmanagementapp.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopmanagementapp.R;
import com.example.shopmanagementapp.ui.Elements.Product;
import com.example.shopmanagementapp.ui.Elements.ProductManager;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private ProductManager productManager;
    private ListView listViewProducts;
    private SearchView searchViewProducts;
    private ArrayAdapter<Product> productAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        // Initialize ProductManager and UI elements
        productManager = new ProductManager();
        listViewProducts = root.findViewById(R.id.listViewProducts);
        searchViewProducts = root.findViewById(R.id.searchViewProducts);

        // Set up the product list view
        ArrayList<Product> productList = productManager.getAllProducts();
        productAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, productList);
        listViewProducts.setAdapter(productAdapter);

        // Set up search functionality
        searchViewProducts.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter products based on the search query
                productAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return root;
    }
}
