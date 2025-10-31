package io.theja.saga.orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// TODO 09: Add retry.
@EnableRetry
public class OrchestratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrchestratorApplication.class, args);
    }

    // TODO 10: Add RestTemplate bean.
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

/*
TODO 20:
http://localhost:8081/h2-console
    jdbc:h2:mem:orders

http://localhost:8082/h2-console
    jdbc:h2:mem:payments

-----------------------------------------------------------------------------------------------------------------------
Failure Case
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8080/sagas' \
--header 'Content-Type: application/json' \
--data '{
    "product":"Book",
    "quantity":1,
    "amount":500
}'

-----------------------------------------------------------------------------------------------------------------------
Success Case
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8080/sagas' \
--header 'Content-Type: application/json' \
--data '{
    "product":"Laptop",
    "quantity":1,
    "amount":1500
}'

SELECT * FROM ORDERS;
ID  	AMOUNT  	PRODUCT  	QUANTITY  	STATUS
064df027-2cb5-4cda-a6ea-0f9f2b424e1e	500.0	Book	1	CREATED
dc37e114-0d85-494f-b0e6-06d5e3ef4b1a	1500.0	Laptop	1	CANCELLED

SELECT * FROM PAYMENTS;
PAYMENT_ID  	AMOUNT  	ORDER_ID  	STATUS
b0d4ea48-230e-4195-9ff2-c8d65dcbdbdb	500.0	064df027-2cb5-4cda-a6ea-0f9f2b424e1e	COMPLETED
 */
