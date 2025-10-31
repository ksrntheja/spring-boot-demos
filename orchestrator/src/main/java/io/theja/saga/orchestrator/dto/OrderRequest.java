package io.theja.saga.orchestrator.dto;

// TODO 08: Add DTOs.
public class OrderRequest {

    private String product;
    private int quantity;
    private double amount;

    public OrderRequest() {
    }

    public OrderRequest(String product, int quantity, double amount) {
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
