package com.example.shopmanagementapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shopmanagementapp.R;
import com.example.shopmanagementapp.databinding.FragmentHomeBinding;
import com.example.shopmanagementapp.ui.Adapters.ProductAdapter;
import com.example.shopmanagementapp.ui.Elements.Product;

public class HomeFragment extends Fragment implements ProductInputDialogFragment.OnAddProductListener {

    private FragmentHomeBinding binding;
    private ListView mListView;
    private ProductAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button addProductButton = root.findViewById(R.id.btn_add_product);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductInputDialogFragment dialogFragment = new ProductInputDialogFragment();
                dialogFragment.setOnAddProductListener(HomeFragment.this); // Set listener to the current fragment
                dialogFragment.show(getParentFragmentManager(), "ProductInputDialogFragment"); // Use getParentFragmentManager() to get the fragment manager
            }
        });

        mListView = root.findViewById(R.id.listViewProducts);
        mAdapter = new ProductAdapter(getContext(), Product.productsArrayList);
        mListView.setAdapter(mAdapter);

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAddProduct(String name, Float price, int quantity) {
        // Implement logic to add product here
    }
}
