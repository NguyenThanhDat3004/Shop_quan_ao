package com.mycompany.shop_ao_quan.model;

import java.time.LocalDate;

public class Invoice {
    private int invoiceId;
    private OrderEntity order;
    private LocalDate invoiceDate;

    public Invoice() {}

    public Invoice(int invoiceId, OrderEntity order, LocalDate invoiceDate) {
        this.invoiceId = invoiceId;
        this.order = order;
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
