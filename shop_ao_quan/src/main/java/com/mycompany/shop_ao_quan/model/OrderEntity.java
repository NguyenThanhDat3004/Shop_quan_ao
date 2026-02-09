package com.mycompany.shop_ao_quan.model;

import java.time.LocalDate;

public class OrderEntity {
    private int orderId;
    private Employee employee;
    private LocalDate orderDate;
    private double totalAmount;
    private String status;

    public OrderEntity() {}

    public OrderEntity(int orderId, Employee employee, LocalDate orderDate,
                       double totalAmount, String status) {
        this.orderId = orderId;
        this.employee = employee;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}