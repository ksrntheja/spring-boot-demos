package io.theja.saga.orchestrator.dto;

public class PaymentRequest {

    private String orderId;
    private double amount;

    public PaymentRequest() {
    }

    public PaymentRequest(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}