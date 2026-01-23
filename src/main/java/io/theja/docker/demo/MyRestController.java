package io.theja.docker.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${APP_MESSAGE}")
    private String appMessage;

    @Value("${DB_PASSWORD}")
    private String dbPassword;

    @GetMapping
    public String myRestEndPoint() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        return "Hi from -> host: " + hostname;
    }

    @GetMapping("/properties")
    public Map<String, String> properties() {
        Map<String, String> map = new HashMap<>();
        System.out.println("======");
        System.out.println(applicationName);
        System.out.println(appMessage);
        System.out.println(dbPassword);
        System.out.println("======");
        System.out.println("====== Docker ENV / run -e PROPERTIES STARTED ======");
        System.getenv().forEach(
                (key, value) -> {
                    System.out.println(key + ": " + value);
                    map.put(key, value);
                }
        );
        System.out.println("====== Docker ENV / run -e PROPERTIES ENDED ======");
        System.out.println("====== Docker JVM -D in ENTRYPOINT PROPERTIES STARTED ======");
        System.getProperties().forEach(
                (key, value) -> {
                    System.out.println(key + ": " + value);
                    map.put(key.toString(), value.toString());
                }
        );
        System.out.println("====== Docker JVM -D in ENTRYPOINT PROPERTIES ENDED ======");
        return map;
    }

}
