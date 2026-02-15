package com.mycompany.shop_ao_quan.model;

public class Product {
    private int productId;
    private String name;
    private String category;
    private String imageUrl;
    public Product() {}

    public Product(int productId, String name, String category, String image) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.imageUrl = image;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    
}