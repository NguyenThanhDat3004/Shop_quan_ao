package com.mycompany.shop_ao_quan.model;

public class OrderItem {
    private int orderItemId;
    private OrderEntity order;
    private ProductVariant variant;
    private int quantity;
    private double price;

    public OrderItem() {}

    public OrderItem(int orderItemId, OrderEntity order,
                     ProductVariant variant, int quantity, double price) {
        this.orderItemId = orderItemId;
        this.order = order;
        this.variant = variant;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductVariant getVariant() {
        return variant;
    }

    public void setVariant(ProductVariant variant) {
        this.variant = variant;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
