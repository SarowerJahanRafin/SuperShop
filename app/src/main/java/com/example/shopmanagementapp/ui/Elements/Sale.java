package com.example.shopmanagementapp.ui.Elements;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    public ArrayList<SaleProduct> sale_product_list = new ArrayList<>();
    String sale_id;
    Date  sale_date;
    int sale_total_price;
    String sale_customer_id;
    String sale_employee_id;

    public Sale(String sale_id, Date sale_date, int sale_total_price, String sale_customer_id, String sale_employee_id) {
        this.sale_id = sale_id;
        this.sale_date = sale_date;
        this.sale_total_price = sale_total_price;
        this.sale_customer_id = sale_customer_id;
        this.sale_employee_id = sale_employee_id;
    }

    public ArrayList<SaleProduct> getSale_product_list() {
        return sale_product_list;
    }

    public void setSale_product_list(ArrayList<SaleProduct> sale_product_list) {
        this.sale_product_list = sale_product_list;
    }

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public int getSale_total_price() {
        return sale_total_price;
    }

    public void setSale_total_price(int sale_total_price) {
        this.sale_total_price = sale_total_price;
    }

    public String getSale_customer_id() {
        return sale_customer_id;
    }

    public void setSale_customer_id(String sale_customer_id) {
        this.sale_customer_id = sale_customer_id;
    }

    public String getSale_employee_id() {
        return sale_employee_id;
    }

    public void setSale_employee_id(String sale_employee_id) {
        this.sale_employee_id = sale_employee_id;
    }

    public void addSaleProduct(SaleProduct saleProduct) {
        sale_product_list.add(saleProduct);
    }

    public void deleteSaleProduct(SaleProduct saleProduct) {
        sale_product_list.remove(saleProduct);
    }

    public void addSale(Sale sale) {
        salesArrayList_of_sales.add(sale);
    }

    public static ArrayList<Sale> salesArrayList_of_sales = new ArrayList<>();
}
