package com.example.shopmanagementapp.ui.Elements;

public class SaleProduct {

    Product product;
    int quantity;
    public SaleProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void deleteQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public void deleteProduct() {
        this.product = null;
    }
}
