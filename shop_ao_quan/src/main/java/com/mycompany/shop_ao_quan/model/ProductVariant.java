package com.mycompany.shop_ao_quan.model;

public class ProductVariant {
    private int variantId;
    private Product product;
    private ProductSize size;
    private Color color;
    private double price;
    private int stock;

    public ProductVariant() {}

    public ProductVariant(int variantId, Product product,
                          ProductSize size, Color color,
                          double price, int stock) {
        this.variantId = variantId;
        this.product = product;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}