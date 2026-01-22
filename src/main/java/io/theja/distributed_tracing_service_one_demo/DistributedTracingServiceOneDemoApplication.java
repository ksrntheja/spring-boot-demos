package io.theja.distributed_tracing_service_one_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistributedTracingServiceOneDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedTracingServiceOneDemoApplication.class, args);
    }

}

/*
TODO 5:

Service 1
2026-01-22T17:52:24.971+05:30  INFO 6356 --- [distributed-tracing-service-one-demo] [           main] [                                                 ] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
Service 2
2026-01-22T17:52:37.264+05:30  INFO 26660 --- [distributed-tracing-service-two-demo] [           main] [                                                 ] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8081 (http) with context path '/'
Service 3
2026-01-22T17:52:34.521+05:30  INFO 34464 --- [distributed-tracing-service-three-demo] [           main] [                                                 ] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8082 (http) with context path '/'
http://localhost:8080/
Service 1
2026-01-22T17:54:35.035+05:30  INFO 6356 --- [distributed-tracing-service-one-demo] [nio-8080-exec-1] [69721702cbebba021067632ecbaf2954-1067632ecbaf2954] i.t.d.ServiceOneRestController           : Request received for service one!
Service 2
2026-01-22T17:54:35.175+05:30  INFO 26660 --- [distributed-tracing-service-two-demo] [nio-8081-exec-1] [69721702cbebba021067632ecbaf2954-04c8f336542950bd] i.t.d.ServiceTwoRestController           : Request received for service two!
Service 3
2026-01-22T17:54:35.326+05:30  INFO 34464 --- [distributed-tracing-service-three-demo] [nio-8082-exec-1] [69721702cbebba021067632ecbaf2954-46206422f8715708] i.t.d.ServiceThreeRestController         : Request received for service three!

-----------------------------------------------------------------------------------------------------------------------
Add trace logging in Service 2 & Service 3
logging:
  level:
    root: trace
-----------------------------------------------------------------------------------------------------------------------
Service 1
2026-01-22T17:59:02.109+05:30  INFO 6356 --- [distributed-tracing-service-one-demo] [nio-8080-exec-3] [6972180e27e784acc515df9f87fd2fb0-c515df9f87fd2fb0] i.t.d.ServiceOneRestController           : Request received for service one!
Service 2
2026-01-22T17:59:02.146+05:30 DEBUG 3924 --- [distributed-tracing-service-two-demo] [nio-8081-exec-1] [                                                 ] o.a.coyote.http11.Http11InputBuffer      : Received [GET / HTTP/1.1
Connection: Upgrade, HTTP2-Settings
Host: localhost:8081
HTTP2-Settings: AAEAAEAAAAIAAAAAAAMAAAAAAAQBAAAAAAUAAEAAAAYABgAA
Upgrade: h2c
User-Agent: Java-http-client/21.0.6
Accept: text/plain, application/json, application/*+json, *//*
traceparent: 00-6972180e27e784acc515df9f87fd2fb0-0c0fb866d3a24d12-01

]
Service 3
2026-01-22T17:59:02.146+05:30 DEBUG 3924 --- [distributed-tracing-service-two-demo] [nio-8081-exec-1] [                                                 ] o.a.coyote.http11.Http11InputBuffer      : Received [GET / HTTP/1.1
Connection: Upgrade, HTTP2-Settings
Host: localhost:8081
HTTP2-Settings: AAEAAEAAAAIAAAAAAAMAAAAAAAQBAAAAAAUAAEAAAAYABgAA
Upgrade: h2c
User-Agent: Java-http-client/21.0.6
Accept: text/plain, application/json, application/*+json, *//*
traceparent: 00-6972180e27e784acc515df9f87fd2fb0-0c0fb866d3a24d12-01

]

-----------------------------------------------------------------------------------------------------------------------
Single Header Format (b3 single)
-----------------------------------------------------------------------------------------------------------------------
Combines all context into one header, b3, with values delimited by hyphens.
b3: {TraceId}-{SpanId}-{Sampled}-{ParentSpanId}.
Example: b3: 80f198ee56343ba864fe8b2a57d3eff7-05e3ac9a4f6e3b90-1-e457b5a2e4d86bd1.

 */
