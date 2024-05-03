package com.example.shopmanagementapp.ui.Elements;

import java.util.ArrayList;

public class Product {

    private String name;
    private Float price;
    private int Quantity;
    private String id; // 20 digits
    private String Description;
    private float weight;

    public static ArrayList<Product> productsArrayList = new ArrayList<>();

    public Product(String name, Float price, int Quantity, String id, String Description, float weight) {
        this.name = name;
        this.price = price;
        this.Quantity = Quantity;
        this.id = id;
        this.Description = Description;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public int getQuantityInt() {
        return Quantity;
    }
    public void setQuantityInt(int Quantity) {
        this.Quantity = Quantity;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Quantity=" + Quantity +
                ", id='" + id + '\'' +
                ", Description='" + Description + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void addProduct(){
        productsArrayList.add(this);
    }

    public String getRandomId(){
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            int random = (int) (Math.random() * 10);
            id.append(random);
        }
        return id.toString();
    }

    boolean doesProductExist(Product product) {
        for (Product p : productsArrayList) {
            if (p.getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product product) {
        if(!doesProductExist(product)) {
            productsArrayList.add(product);
        }
    }

//    public static ArrayList<Product> getProductsArrayList() {
//        return productsArrayList;
//    }


}
