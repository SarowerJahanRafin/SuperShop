package com.example.shopmanagementapp.ui.home;

import static com.example.shopmanagementapp.ui.Elements.Product.productsArrayList;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.shopmanagementapp.R;
import com.example.shopmanagementapp.ui.Elements.Product;

import java.util.ArrayList;

public class ProductInputDialogFragment extends DialogFragment {

    private EditText editTextName;
    private EditText editTextPrice;
    private EditText editTextQuantity;
    private EditText editTextId;
    private EditText editTextDescription;
    private EditText editTextWeight;
    private Button buttonAddProduct;

    private OnAddProductListener listener;

    public interface OnAddProductListener {
        void onAddProduct(String name, Float price, int quantity);
    }

    public void setOnAddProductListener(OnAddProductListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_input_layout, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextPrice = view.findViewById(R.id.editTextPrice);
        editTextQuantity = view.findViewById(R.id.editTextQuantity);
        editTextId = view.findViewById(R.id.editTextId);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        editTextWeight = view.findViewById(R.id.editTextWeight);
        buttonAddProduct = view.findViewById(R.id.buttonAddProduct);

        if(editTextName.getText().toString().isEmpty() || editTextPrice.getText().toString().isEmpty() || editTextQuantity.getText().toString().isEmpty()
        || editTextId.getText().toString().isEmpty() || editTextDescription.getText().toString().isEmpty() || editTextWeight.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_LONG).show();
        }

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                Float price = Float.parseFloat(editTextPrice.getText().toString());
                int quantity = Integer.parseInt(editTextQuantity.getText().toString());
                String id = editTextId.getText().toString();
                String description = editTextDescription.getText().toString();
                float weight = Float.parseFloat(editTextWeight.getText().toString());

                Product product = new Product(name, price, quantity, id, description, weight);
                product.addProduct(product);

                if (listener != null) {
                    listener.onAddProduct(name, price, quantity);
                }
                dismiss();
            }
        });

        return view;
    }
}
