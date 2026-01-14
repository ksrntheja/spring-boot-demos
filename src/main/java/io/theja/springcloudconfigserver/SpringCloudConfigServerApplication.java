package io.theja.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// TODO 3: Add @EnableConfigServer annotation.
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }

}

/*

TODO 4:

Git branch per environment set-up
main   → prod
new-feature → dev

-----------------------------------------------------------------------------------------------------------------------
Service: spring-cloud-config-server: branch main
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8888/spring-cloud-config-server/default' \
--header 'Authorization: Basic YWRtaW46YWRtaW4xMjM='
OR
http://admin:admin123@localhost:8888/spring-cloud-config-server/default/main

-----------------------------------------------------------------------------------------------------------------------
Service: spring-cloud-config-service-a: branch main
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8888/spring-cloud-config-service-a/default' \
--header 'Authorization: Basic YWRtaW46YWRtaW4xMjM='


-----------------------------------------------------------------------------------------------------------------------
Service: spring-cloud-config-server: branch new-feature
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8888/spring-cloud-config-server/default/new-feature' \
--header 'Authorization: Basic YWRtaW46YWRtaW4xMjM='
OR
http://admin:admin123@localhost:8888/spring-cloud-config-server/default/main

-----------------------------------------------------------------------------------------------------------------------
Service: spring-cloud-config-service-a: branch new-feature
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8888/spring-cloud-config-service-a/default/new-feature' \
--header 'Authorization: Basic YWRtaW46YWRtaW4xMjM='

 */
