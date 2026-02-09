package com.mycompany.shop_ao_quan.model;

import java.time.LocalDate;

public class Payment {
    private int paymentId;
    private OrderEntity order;
    private String paymentMethod;
    private double paidAmount;
    private LocalDate paymentTime;
    private String paymentStatus;

    public Payment() {}

    public Payment(int paymentId, OrderEntity order, String paymentMethod,
                   double paidAmount, LocalDate paymentTime, String paymentStatus) {
        this.paymentId = paymentId;
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paidAmount = paidAmount;
        this.paymentTime = paymentTime;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDate getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDate paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}