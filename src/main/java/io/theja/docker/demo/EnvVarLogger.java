package io.theja.docker.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class EnvVarLogger {

    @EventListener(ApplicationReadyEvent.class)
    public void logAllProperties(ApplicationReadyEvent event) {
        ConfigurableEnvironment env = event.getApplicationContext().getEnvironment();
        System.out.println("====== ALL CONFIGURATION SOURCES STARTED ======");
        for (PropertySource<?> source : env.getPropertySources()) {
            if (source instanceof EnumerablePropertySource) {
                System.out.println("\nSource: " + source.getName());
                String[] propNames = ((EnumerablePropertySource<?>) source).getPropertyNames();
                for (String name : propNames) {
                    System.out.println(name + " = " + env.getProperty(name));
                }
            }
        }
        System.out.println("====== ALL CONFIGURATION SOURCES DONE ======");
    }

}
