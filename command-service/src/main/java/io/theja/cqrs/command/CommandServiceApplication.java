package io.theja.cqrs.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandServiceApplication.class, args);
    }

}

/*
TODO 18:

Command Query Responsibility Segregation (CQRS)

cmd - Run as admin
zookeeper -> :2181
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
kafka-server / kafka-broker -> :9092
.\bin\windows\kafka-server-start.bat .\config\server.properties

http://localhost:8081/h2-console
    jdbc:h2:mem:commanddb

http://localhost:8082/h2-console
    jdbc:h2:mem:querydb

-----------------------------------------------------------------------------------------------------------------------
Create Product
-----------------------------------------------------------------------------------------------------------------------
curl --location 'localhost:8081/commands/products' \
--header 'Content-Type: application/json' \
--data '{
    "name":"Widget",
    "price":19.99
}'

-----------------------------------------------------------------------------------------------------------------------
Get all products
-----------------------------------------------------------------------------------------------------------------------
curl --location 'localhost:8082/queries/products'

-----------------------------------------------------------------------------------------------------------------------
Update a product
-----------------------------------------------------------------------------------------------------------------------
curl --location --request PUT 'localhost:8081/commands/products/4aaba348-9c41-4d07-a0f9-f3cc6380f41c' \
--header 'Content-Type: application/json' \
--data '{
    "price":24.99
}'

SELECT * FROM PRODUCT_VIEW;
ID  	NAME  	PRICE
4aaba348-9c41-4d07-a0f9-f3cc6380f41c	Widget	24.99

SELECT * FROM PRODUCT;
ID  	NAME  	PRICE
4aaba348-9c41-4d07-a0f9-f3cc6380f41c	Widget	19.99

 */

