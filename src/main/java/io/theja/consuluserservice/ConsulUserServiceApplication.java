package io.theja.consuluserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsulUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulUserServiceApplication.class, args);
    }

}


/*

TODO 4:

-----------------------------------------------------------------------------------------------------------------------
Install consul
-----------------------------------------------------------------------------------------------------------------------
Download consul_1.21.2_windows_amd64.zip.
Extract.
consul --version
    Consul v1.21.2
    Revision 136b9cb8
    Build Date 2025-06-18T08:16:39Z
    Protocol 2 spoken by default, understands 2 to 3 (agent will automatically use protocol >2 when speaking to compatible agents)
Start
consul agent -dev

-----------------------------------------------------------------------------------------------------------------------
Add Key/Value in consul UI
-----------------------------------------------------------------------------------------------------------------------
- Open the consul UI.
- Navigate to Key/Value.
- Create a folder named config/.
- Inside config/, create a folder named consul-user-service/.
- Inside that folder, create the key foo.
    Full Key Path: config/consul-user-service/foo
Set the value to whatever you need and Save.

-----------------------------------------------------------------------------------------------------------------------
Service Registration
-----------------------------------------------------------------------------------------------------------------------
curl http://localhost:8500/v1/agent/services
Response
{
    "consul-user-service-8080": {
        "ID": "consul-user-service-8080",
        "Service": "consul-user-service",
        "Tags": [],
        "Meta": {
            "secure": "false"
        },
        "Port": 8080,
        "Address": "ktheja",
        "Weights": {
            "Passing": 1,
            "Warning": 1
        },
        "EnableTagOverride": false,
        "Datacenter": "dc1"
    }
}

-----------------------------------------------------------------------------------------------------------------------
Health Check
-----------------------------------------------------------------------------------------------------------------------
curl http://localhost:8500/v1/health/checks/consul-user-service
Response
[
    {
        "Node": "ktheja",
        "CheckID": "service:consul-user-service-8080",
        "Name": "Service 'consul-user-service' check",
        "Status": "passing",
        "Notes": "",
        "Output": "HTTP GET http://ktheja:8080/actuator/health: 200  Output: {\"status\":\"UP\"}",
        "ServiceID": "consul-user-service-8080",
        "ServiceName": "consul-user-service",
        "ServiceTags": [],
        "Type": "http",
        "Interval": "10s",
        "Timeout": "",
        "ExposedPort": 0,
        "Definition": {},
        "CreateIndex": 37,
        "ModifyIndex": 38
    }
]

http://localhost:8500/v1/catalog/service/consul-user-service
Cannot access app /users/hello. Can do http://localhost:8080/users/hello.

-----------------------------------------------------------------------------------------------------------------------
Start consumer -> consul-user-service-consumer
-----------------------------------------------------------------------------------------------------------------------
http://localhost:8080/
Response
Hello World bar from User Service 8080.

-----------------------------------------------------------------------------------------------------------------------
Update the value in consul UI
-----------------------------------------------------------------------------------------------------------------------
See below in logs
2026-01-20T16:56:56.864+05:30  INFO 5820 --- [consul-user-service] [TaskScheduler-1] o.s.c.e.event.RefreshEventListener       : Refresh keys changed: [foo]

http://localhost:8080/
Response
Hello World bar updated from User Service 8080.

*** No restart or calling curl -X POST http://localhost:8080/actuator/refresh.

 */
