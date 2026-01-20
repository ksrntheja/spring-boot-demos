package io.theja.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}

/*

TODO 17:

cmd - Run as admin
zookeeper -> :2181
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
kafka-server / kafka-broker -> :9092
.\bin\windows\kafka-server-start.bat .\config\server.properties

http://localhost:8081/h2-console
    jdbc:h2:mem:ordersdb

http://localhost:8082/h2-console
    jdbc:h2:mem:ordersview

-----------------------------------------------------------------------------------------------------------------------
Create Order
-----------------------------------------------------------------------------------------------------------------------
curl --location 'localhost:8081/orders' \
--header 'Content-Type: application/json' \
--data '{
    "product":"Book",
    "quantity":2
}'
Response
{
    "id": "e09e83df-babf-4718-9b9c-5f46276edd01",
    "product": "Book",
    "quantity": 2,
    "status": "CREATED"
}

-----------------------------------------------------------------------------------------------------------------------
ordersdb
-----------------------------------------------------------------------------------------------------------------------
SELECT * FROM ORDERS;
ID  	PRODUCT  	QUANTITY  	STATUS
e09e83df-babf-4718-9b9c-5f46276edd01	Book	2	CREATED
SELECT * FROM OUTBOX_EVENTS;
ID  	AGGREGATE_ID  	AGGREGATE_TYPE  	CREATED_AT  	EVENT_TYPE  	PAYLOAD  	PUBLISHED
b3923ff2-9a63-469e-b11c-45ea120fd6b1	e09e83df-babf-4718-9b9c-5f46276edd01	Order	2026-01-20 12:21:57.545151+05:30	OrderCreated	{"id":"e09e83df-babf-4718-9b9c-5f46276edd01","product":"Book","quantity":2,"status":"CREATED"}	FALSE

Hibernate: update outbox_events set aggregate_id=?,aggregate_type=?,created_at=?,event_type=?,payload=?,published=? where id=?
Triggered order-event!
SELECT * FROM OUTBOX_EVENTS;
ID  	AGGREGATE_ID  	AGGREGATE_TYPE  	CREATED_AT  	EVENT_TYPE  	PAYLOAD  	PUBLISHED
b3923ff2-9a63-469e-b11c-45ea120fd6b1	e09e83df-babf-4718-9b9c-5f46276edd01	Order	2026-01-20 12:21:57.545151+05:30	OrderCreated	{"id":"e09e83df-babf-4718-9b9c-5f46276edd01","product":"Book","quantity":2,"status":"CREATED"}	TRUE
-----------------------------------------------------------------------------------------------------------------------
ordersview
-----------------------------------------------------------------------------------------------------------------------
SELECT * FROM ORDER_VIEW;
ID  	PRODUCT  	QUANTITY  	STATUS
e09e83df-babf-4718-9b9c-5f46276edd01	Book	2	CREATED


-----------------------------------------------------------------------------------------------------------------------
View all orders
-----------------------------------------------------------------------------------------------------------------------
curl --location 'localhost:8082/orders'
Response
[
    {
        "id": "e09e83df-babf-4718-9b9c-5f46276edd01",
        "product": "Book",
        "quantity": 2,
        "status": "CREATED"
    }
]

-----------------------------------------------------------------------------------------------------------------------
View an order
-----------------------------------------------------------------------------------------------------------------------
curl --location 'localhost:8082/orders/e09e83df-babf-4718-9b9c-5f46276edd01'
Response
{
    "id": "e09e83df-babf-4718-9b9c-5f46276edd01",
    "product": "Book",
    "quantity": 2,
    "status": "CREATED"
}

 */
