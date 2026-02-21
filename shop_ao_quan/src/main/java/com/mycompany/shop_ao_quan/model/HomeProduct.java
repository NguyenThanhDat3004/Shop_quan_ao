/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.shop_ao_quan.model;

public class HomeProduct {

    private int productId;
    private String name;
    private String imageUrl;
    private double price;
    private int stock;

    public HomeProduct() {
    }

    public HomeProduct(int productId, String name,
                       String imageUrl, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}