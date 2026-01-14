package io.theja.springcloudconfigservicea;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO 3: Add controller.
@SpringBootApplication
public class SpringCloudConfigServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServiceAApplication.class, args);
    }

//    TODO 4: Add @RefreshScope annotation.
    @RestController
    @RefreshScope
    class GreetingController {

        @Value("${service.greeting:Default greeting}")
        private String greeting;

        @GetMapping("/greet")
        public String greet() {
            return greeting;
        }
    }

}

/*

TODO 5:

-----------------------------------------------------------------------------------------------------------------------
  cloud:
    config:
      label: main
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8081/greet'
Response
Hello from Service A (Development Environment)

-----------------------------------------------------------------------------------------------------------------------
  cloud:
    config:
      label: new-feature
-----------------------------------------------------------------------------------------------------------------------
Port changed
curl --location 'http://localhost:8080/greet'
Response
Hello from Service A (dev)

-----------------------------------------------------------------------------------------------------------------------
actuator/refresh
-----------------------------------------------------------------------------------------------------------------------
Make changes in git,
curl --location --request POST 'http://localhost:8081/actuator/refresh'
Response
[
    "config.client.version",
    "service.greeting"
]
Logs
2026-01-14T12:04:32.210+05:30  INFO 25812 --- [spring-cloud-config-service-a] [nio-8081-exec-6] o.s.c.c.c.ConfigServerConfigDataLoader   : Fetching config from server at : http://localhost:8888
2026-01-14T12:04:33.291+05:30  INFO 25812 --- [spring-cloud-config-service-a] [nio-8081-exec-6] o.s.c.c.c.ConfigServerConfigDataLoader   : Located environment: name=spring-cloud-config-service-a, profiles=[default], label=main, version=013c342a41fef9f550d09e8ca1bac952b3b0b3ee, state=
2026-01-14T12:04:33.305+05:30  INFO 25812 --- [spring-cloud-config-service-a] [nio-8081-exec-6] o.s.cloud.endpoint.RefreshEndpoint       : Refreshed keys : [config.client.version, service.greeting]

Response from service without restart
Hello from Service A (Development Environment [New])




 */