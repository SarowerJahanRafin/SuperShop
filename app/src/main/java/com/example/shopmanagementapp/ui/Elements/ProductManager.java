package com.example.shopmanagementapp.ui.Elements;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ArrayList<Product> productList = new ArrayList<>();

    // Add sample products to the list
    static {
        Product product1 = new Product("Product 1", 10.0f, 10, "1", "Description 1", 1.0f);
        Product product2 = new Product("Product 2", 20.0f, 20, "2", "Description 2", 2.0f);
        Product product3 = new Product("Product 3", 30.0f, 30, "3", "Description 3", 3.0f);


        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }

    public ArrayList<Product> getAllProducts() {
        return productList;
    }

    // Add a product to the list
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Remove a product from the list
    public void removeProduct(Product product) {
        productList.remove(product);
    }
}

