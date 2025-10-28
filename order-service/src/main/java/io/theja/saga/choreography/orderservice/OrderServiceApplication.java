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
 */
