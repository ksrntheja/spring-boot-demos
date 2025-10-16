package io.ksrntheja.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

}

/*
TODO 7: Run
show DATABASES;
SELECT DATABASE();
GRANT ALL PRIVILEGES ON springdemo.* TO 'new_user'@'localhost';
FLUSH PRIVILEGES;

cmd - Run as admin
zookeeper -> :2181
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
kafka-server / kafka-broker -> :9092
.\bin\windows\kafka-server-start.bat .\config\server.properties

Send message to 'my-topic'
http://localhost:8080/send/hike

Send message to 'kafka-topic'
http://localhost:8080/send/kafka-topic/hike
ab -n 10000 -c 100 http://localhost:8080/send/kafka-topic/hike
 */
