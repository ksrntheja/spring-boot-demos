package io.theja.saga.choreography.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}

/*
TODO 21:
cmd - Run as admin
zookeeper -> :2181
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
kafka-server / kafka-broker -> :9092
.\bin\windows\kafka-server-start.bat .\config\server.properties

http://localhost:8081/h2-console
    jdbc:h2:mem:orders

http://localhost:8082/h2-console
    jdbc:h2:mem:payments

-----------------------------------------------------------------------------------------------------------------------
Failure Case
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8081/orders' \
--header 'Content-Type: application/json' \
--data '{
    "product":"Laptop",
    "quantity":1,
    "amount":1500
}'

-----------------------------------------------------------------------------------------------------------------------
Success Case
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8081/orders' \
--header 'Content-Type: application/json' \
--data '{
    "product":"Book",
    "quantity":1,
    "amount":500
}'

SELECT * FROM ORDERS;
ID  	AMOUNT  	PRODUCT  	QUANTITY  	STATUS
2505c7c9-c020-494a-bbf1-3c68bd5a6fa8	500.0	Book	1	COMPLETED
03c87cb6-ad7d-43be-bd0f-0d9da9fe92bc	1500.0	Laptop	1	CANCELLED

SELECT * FROM PAYMENTS;
PAYMENT_ID  	AMOUNT  	ORDER_ID  	STATUS
16c41d1b-8531-4a4c-bfdb-15c16f555ff6	500.0	2505c7c9-c020-494a-bbf1-3c68bd5a6fa8	COMPLETED

 */
