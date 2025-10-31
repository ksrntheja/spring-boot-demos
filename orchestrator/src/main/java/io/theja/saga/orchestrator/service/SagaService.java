package io.theja.saga.orchestrator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.theja.saga.orchestrator.dto.OrderRequest;
import io.theja.saga.orchestrator.dto.OrderResponse;
import io.theja.saga.orchestrator.dto.PaymentRequest;
import io.theja.saga.orchestrator.dto.PaymentResponse;

// TODO 07: Add service.
@Service
public class SagaService {

    private final RestTemplate rest;
    private final String orderUrl;
    private final String paymentUrl;

    public SagaService(
            RestTemplate rest,
            @Value("${services.order.url}") String orderUrl,
            @Value("${services.payment.url}") String paymentUrl
    ) {
        this.rest = rest;
        this.orderUrl = orderUrl;
        this.paymentUrl = paymentUrl;
    }

    public void process(OrderRequest req) {
        OrderResponse order = createOrder(req);
        try {
            processPayment(new PaymentRequest(order.getId(), req.getAmount()));
        } catch (Exception ex) {
            System.out.println("compensateOrder");
            compensateOrder(order.getId());
            throw new RuntimeException("Saga aborted: payment failed", ex);
        }
    }

    @Retryable(
            value = {HttpClientErrorException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    private OrderResponse createOrder(OrderRequest req) {
        return rest.postForObject(orderUrl + "/orders", req, OrderResponse.class);
    }

    @Retryable(
            value = {HttpClientErrorException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    private PaymentResponse processPayment(PaymentRequest req) {
        return rest.postForObject(paymentUrl + "/payments", req, PaymentResponse.class);
    }

    private void compensateOrder(String orderId) {
        rest.delete(orderUrl + "/orders/{id}", orderId);
    }

}
