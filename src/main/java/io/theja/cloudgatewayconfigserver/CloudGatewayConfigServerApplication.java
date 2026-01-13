package io.theja.cloudgatewayconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
// TODO 4: Add @EnableConfigServer.
@EnableConfigServer
public class CloudGatewayConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayConfigServerApplication.class, args);
    }

}

/*

http://localhost:8888/actuator/health
Response
{
  "status": "UP"
}

http://localhost:8888/application/default

Change property -> No restart required.

Response
{
  "name": "application",
  "profiles": [
    "default"
  ],
  "label": null,
  "version": null,
  "state": null,
  "propertySources": [
    {
      "name": "file:/C:/Users/ktheja/Work/Code/z/cloud-gateway-config-server/config-repo/application.properties",
      "source": {
        "foo": "bar",
        "test": "test"
      }
    }
  ]
}


Not working -> http://localhost:8888/application/default/dev

 */