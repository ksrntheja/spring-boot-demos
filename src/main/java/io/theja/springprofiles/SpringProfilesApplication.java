package io.theja.springprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProfilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProfilesApplication.class, args);
    }

}

/*
-----------------------------------------------------------------------------------------------------------------------
Without VM options
-----------------------------------------------------------------------------------------------------------------------
http://localhost:8080/greet
Response
Hello from spring-profiles-dev


-----------------------------------------------------------------------------------------------------------------------
For VM options: -Dspring.profiles.active=prod -DMYSQL_PASS=strong_password
-----------------------------------------------------------------------------------------------------------------------
http://localhost:8080/greet
Response
Hello from spring-profiles-prod

actuator
http://localhost:8080/actuator/health
Response
{
    "status": "UP"
}
http://localhost:8080/actuator/metrics
Response
{
    "names": [
        "application.ready.time",
        "application.started.time",
        "disk.free",
        "disk.total",
        "executor.active",
        "executor.completed",
        "executor.pool.core",
        "executor.pool.max",
        "executor.pool.size",
        "executor.queue.remaining",
        "executor.queued",
        "hikaricp.connections",
        "hikaricp.connections.acquire",
        "hikaricp.connections.active",
        "hikaricp.connections.creation",
        "hikaricp.connections.idle",
        "hikaricp.connections.max",
        "hikaricp.connections.min",
        "hikaricp.connections.pending",
        "hikaricp.connections.timeout",
        "hikaricp.connections.usage",
        "http.server.requests",
        "http.server.requests.active",
        "jdbc.connections.active",
        "jdbc.connections.idle",
        "jdbc.connections.max",
        "jdbc.connections.min",
        "jvm.buffer.count",
        "jvm.buffer.memory.used",
        "jvm.buffer.total.capacity",
        "jvm.classes.loaded",
        "jvm.classes.unloaded",
        "jvm.compilation.time",
        "jvm.gc.live.data.size",
        "jvm.gc.max.data.size",
        "jvm.gc.memory.allocated",
        "jvm.gc.memory.promoted",
        "jvm.gc.overhead",
        "jvm.gc.pause",
        "jvm.info",
        "jvm.memory.committed",
        "jvm.memory.max",
        "jvm.memory.usage.after.gc",
        "jvm.memory.used",
        "jvm.threads.daemon",
        "jvm.threads.live",
        "jvm.threads.peak",
        "jvm.threads.started",
        "jvm.threads.states",
        "logback.events",
        "process.cpu.time",
        "process.cpu.usage",
        "process.start.time",
        "process.uptime",
        "system.cpu.count",
        "system.cpu.usage",
        "tomcat.sessions.active.current",
        "tomcat.sessions.active.max",
        "tomcat.sessions.alive.max",
        "tomcat.sessions.created",
        "tomcat.sessions.expired",
        "tomcat.sessions.rejected"
    ]
}
http://localhost:8080/actuator/metrics/application.ready.time
Response
{
    "name": "application.ready.time",
    "description": "Time taken for the application to be ready to service requests",
    "baseUnit": "seconds",
    "measurements": [
        {
            "statistic": "VALUE",
            "value": 5.746
        }
    ],
    "availableTags": [
        {
            "tag": "main.application.class",
            "values": [
                "io.theja.springprofiles.SpringProfilesApplication"
            ]
        }
    ]
}
http://localhost:8080/actuator/beans
{
    "contexts": {
        "spring-profiles-prod": {
            "beans": {
                "spring.jpa-org.springframework.boot.autoconfigure.orm.jpa.JpaProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.orm.jpa.JpaProperties",
                    "dependencies": []
                },
                "endpointCachingOperationInvokerAdvisor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.invoker.cache.CachingOperationInvokerAdvisor",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/EndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration",
                        "environment"
                    ]
                },
                "defaultServletHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.HandlerMapping",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "applicationTaskExecutor": {
                    "aliases": [
                        "bootstrapExecutor"
                    ],
                    "scope": "singleton",
                    "type": "org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskExecutorConfigurations$TaskExecutorConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$TaskExecutorConfiguration",
                        "threadPoolTaskExecutorBuilder"
                    ]
                },
                "persistenceExceptionTranslationPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/dao/PersistenceExceptionTranslationAutoConfiguration.class]",
                    "dependencies": [
                        "environment"
                    ]
                },
                "management.health.db-org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthIndicatorProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthIndicatorProperties",
                    "dependencies": []
                },
                "observationRegistryPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.ObservationRegistryPostProcessor",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/ObservationAutoConfiguration.class]",
                    "dependencies": []
                },
                "spring.data.web-org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties",
                    "dependencies": []
                },
                "characterEncodingFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/HttpEncodingAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration"
                    ]
                },
                "healthEndpointGroups": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.AutoConfiguredHealthEndpointGroups",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties"
                    ]
                },
                "sortCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration$$Lambda/0x00000259017b4f60",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/data/web/SpringDataWebAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration"
                    ]
                },
                "management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties",
                    "dependencies": []
                },
                "webEndpointDiscoverer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.annotation.WebEndpointDiscoverer",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration",
                        "endpointOperationParameterMapper",
                        "endpointMediaTypes"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration",
                    "dependencies": [
                        "spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration",
                    "dependencies": [
                        "spring.http.client-org.springframework.boot.autoconfigure.http.client.HttpClientProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration",
                    "dependencies": []
                },
                "preserveErrorControllerTargetClassPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$PreserveErrorControllerTargetClassPostProcessor",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration.class]",
                    "dependencies": []
                },
                "hikariDataSourceMeterBinder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$HikariDataSourceMetricsConfiguration$HikariDataSourceMeterBinder",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/jdbc/DataSourcePoolMetricsAutoConfiguration$HikariDataSourceMetricsConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$HikariDataSourceMetricsConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration",
                    "dependencies": []
                },
                "logbackMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.logging.LogbackMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/LogbackMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration"
                    ]
                },
                "jdbcTemplate": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.jdbc.core.JdbcTemplate",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jdbc/JdbcTemplateConfiguration.class]",
                    "dependencies": [
                        "dataSourceScriptDatabaseInitializer",
                        "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateConfiguration",
                        "dataSource",
                        "spring.jdbc-org.springframework.boot.autoconfigure.jdbc.JdbcProperties"
                    ]
                },
                "management.info-org.springframework.boot.actuate.autoconfigure.info.InfoContributorProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.info.InfoContributorProperties",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration",
                    "dependencies": [
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties"
                    ]
                },
                "webEndpointPathMapper": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.MappingWebEndpointPathMapper",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration",
                    "dependencies": [
                        "dataSource",
                        "spring.jpa-org.springframework.boot.autoconfigure.orm.jpa.JpaProperties",
                        "org.springframework.beans.factory.support.DefaultListableBeanFactory@5d1659ea",
                        "spring.jpa.hibernate-org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$AspectJAutoProxyingConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$AspectJAutoProxyingConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration",
                    "dependencies": [
                        "management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration",
                    "dependencies": []
                },
                "propertySourcesPlaceholderConfigurer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.context.support.PropertySourcesPlaceholderConfigurer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/context/PropertyPlaceholderAutoConfiguration.class]",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration$CglibAutoProxyConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration$CglibAutoProxyConfiguration",
                    "dependencies": []
                },
                "openEntityManagerInViewInterceptor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/orm/jpa/JpaBaseConfiguration$JpaWebConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration",
                    "dependencies": []
                },
                "management.simple.metrics.export-org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties",
                    "dependencies": []
                },
                "beanNameViewResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.view.BeanNameViewResolver",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration",
                    "dependencies": []
                },
                "viewResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.view.ContentNegotiatingViewResolver",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter",
                        "org.springframework.beans.factory.support.DefaultListableBeanFactory@5d1659ea"
                    ]
                },
                "management.endpoints.web.cors-org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties",
                    "dependencies": []
                },
                "stringHttpMessageConverter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.http.converter.StringHttpMessageConverter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/http/HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration",
                        "environment"
                    ]
                },
                "projectingArgumentResolverBeanPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.config.ProjectingArgumentResolverRegistrar$ProjectingArgumentResolverBeanPostProcessor",
                    "resource": "class path resource [org/springframework/data/web/config/ProjectingArgumentResolverRegistrar.class]",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration",
                    "dependencies": []
                },
                "tomcatServletWebServerFactoryCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/ServletWebServerFactoryAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration",
                        "server-org.springframework.boot.autoconfigure.web.ServerProperties"
                    ]
                },
                "server-org.springframework.boot.autoconfigure.web.ServerProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.ServerProperties",
                    "dependencies": []
                },
                "messageConverters": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.http.HttpMessageConverters",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/http/HttpMessageConvertersAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration"
                    ]
                },
                "jsonComponentModule": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.jackson.JsonComponentModule",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration"
                    ]
                },
                "websocketServletWebServerCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/websocket/servlet/WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration"
                    ]
                },
                "entityManagerFactoryBuilder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration",
                        "jpaVendorAdapter"
                    ]
                },
                "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration",
                    "dependencies": []
                },
                "dataSourceScriptDatabaseInitializer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.sql.init.DataSourceInitializationConfiguration",
                        "dataSource",
                        "spring.sql.init-org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration",
                    "dependencies": []
                },
                "mappingJackson2HttpMessageConverter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.http.converter.json.MappingJackson2HttpMessageConverter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/http/JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration",
                        "jacksonObjectMapper"
                    ]
                },
                "applicationTaskExecutorAsyncConfigurer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$AsyncConfigurerConfiguration$1",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskExecutorConfigurations$AsyncConfigurerConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$AsyncConfigurerConfiguration",
                        "org.springframework.beans.factory.support.DefaultListableBeanFactory@5d1659ea"
                    ]
                },
                "meterRegistryPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryPostProcessor",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4"
                    ]
                },
                "org.springframework.boot.autoconfigure.jdbc.JdbcClientAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.JdbcClientAutoConfiguration",
                    "dependencies": []
                },
                "endpointMediaTypes": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
                    ]
                },
                "jvmCompilationMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.jvm.JvmCompilationMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration",
                    "dependencies": []
                },
                "management.health.ssl-org.springframework.boot.actuate.autoconfigure.ssl.SslHealthIndicatorProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.ssl.SslHealthIndicatorProperties",
                    "dependencies": []
                },
                "jdbcConnectionDetailsHikariBeanPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.HikariJdbcConnectionDetailsBeanPostProcessor",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceConfiguration$Hikari.class]",
                    "dependencies": []
                },
                "healthStatusAggregator": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.health.SimpleStatusAggregator",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
                        "management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration",
                    "dependencies": []
                },
                "management.server-org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties",
                    "dependencies": []
                },
                "spring.ssl-org.springframework.boot.autoconfigure.ssl.SslProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.ssl.SslProperties",
                    "dependencies": []
                },
                "servletWebServerFactoryCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/ServletWebServerFactoryAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration",
                        "server-org.springframework.boot.autoconfigure.web.ServerProperties"
                    ]
                },
                "mvcUrlPathHelper": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.util.UrlPathHelper",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "transactionTemplate": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.transaction.support.TransactionTemplate",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/transaction/TransactionAutoConfiguration$TransactionTemplateConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$TransactionTemplateConfiguration",
                        "transactionManager"
                    ]
                },
                "repositoryTagsProvider": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.metrics.data.DefaultRepositoryTagsProvider",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/data/RepositoryMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration"
                    ]
                },
                "dbHealthContributor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/jdbc/DataSourceHealthContributorAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration",
                        "org.springframework.beans.factory.support.DefaultListableBeanFactory@5d1659ea",
                        "management.health.db-org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthIndicatorProperties"
                    ]
                },
                "dataSourcePoolMetadataMeterBinder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$DataSourcePoolMetadataMetricsConfiguration$DataSourcePoolMetadataMeterBinder",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/jdbc/DataSourcePoolMetricsAutoConfiguration$DataSourcePoolMetadataMetricsConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$DataSourcePoolMetadataMetricsConfiguration",
                        "org.springframework.beans.factory.support.DefaultListableBeanFactory@5d1659ea"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.startup.StartupTimeMetricsListenerAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.startup.StartupTimeMetricsListenerAutoConfiguration",
                    "dependencies": []
                },
                "webServerFactoryCustomizerBeanPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$ThreadPoolTaskSchedulerBuilderConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$ThreadPoolTaskSchedulerBuilderConfiguration",
                    "dependencies": []
                },
                "metricsHttpClientUriTagFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.config.MeterFilter$9",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/web/client/HttpClientObservationsAutoConfiguration$MeterFilterConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.web.client.HttpClientObservationsAutoConfiguration$MeterFilterConfiguration",
                        "management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties",
                        "management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration",
                    "dependencies": []
                },
                "management.health.diskspace-org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthIndicatorProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthIndicatorProperties",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksObservabilityAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksObservabilityAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration",
                    "dependencies": []
                },
                "spring.sql.init-org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties",
                    "dependencies": []
                },
                "controllerEndpointHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.servlet.ControllerEndpointHandlerMapping",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/servlet/WebMvcEndpointManagementContextConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration",
                        "controllerEndpointDiscoverer",
                        "management.endpoints.web.cors-org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties",
                        "management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties",
                        "propertiesEndpointAccessResolver"
                    ]
                },
                "org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration",
                    "dependencies": [
                        "spring.jpa-org.springframework.boot.autoconfigure.orm.jpa.JpaProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration",
                    "dependencies": []
                },
                "standardJacksonObjectMapperBuilderCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration$StandardJackson2ObjectMapperBuilderCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration",
                        "spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties"
                    ]
                },
                "jdbcClient": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.jdbc.core.simple.DefaultJdbcClient",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jdbc/JdbcClientAutoConfiguration.class]",
                    "dependencies": [
                        "dataSourceScriptDatabaseInitializer",
                        "org.springframework.boot.autoconfigure.jdbc.JdbcClientAutoConfiguration",
                        "namedParameterJdbcTemplate"
                    ]
                },
                "observabilitySchedulingConfigurer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksObservabilityAutoConfiguration$ObservabilitySchedulingConfigurer",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/scheduling/ScheduledTasksObservabilityAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksObservabilityAutoConfiguration",
                        "observationRegistry"
                    ]
                },
                "metricsEndpoint": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.metrics.MetricsEndpoint",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration",
                        "simpleMeterRegistry"
                    ]
                },
                "management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.ssl.SslObservabilityAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.ssl.SslObservabilityAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration",
                    "dependencies": []
                },
                "metricsObservationHandlerGrouping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.ObservationHandlerGrouping",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/ObservationAutoConfiguration$OnlyMetricsConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$OnlyMetricsConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration",
                    "dependencies": []
                },
                "simpleMeterRegistry": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.simple.SimpleMeterRegistry",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/export/simple/SimpleMetricsExportAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration",
                        "simpleConfig",
                        "micrometerClock"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration",
                    "dependencies": []
                },
                "spring.jpa.hibernate-org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties",
                    "dependencies": []
                },
                "bootstrapExecutorAliasPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$BootstrapExecutorConfiguration$$Lambda/0x00000259013c07e0",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskExecutorConfigurations$BootstrapExecutorConfiguration.class]",
                    "dependencies": []
                },
                "entityManagerFactory": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "jdk.proxy2.$Proxy107",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]",
                    "dependencies": [
                        "dataSourceScriptDatabaseInitializer",
                        "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration",
                        "entityManagerFactoryBuilder",
                        "persistenceManagedTypes"
                    ]
                },
                "conventionErrorViewResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration"
                    ]
                },
                "startupTimeMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.metrics.startup.StartupTimeMetricsListener",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/startup/StartupTimeMetricsListenerAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.startup.StartupTimeMetricsListenerAutoConfiguration",
                        "simpleMeterRegistry"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                    "dependencies": [
                        "spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties",
                        "spring.web-org.springframework.boot.autoconfigure.web.WebProperties",
                        "org.springframework.beans.factory.support.DefaultListableBeanFactory@5d1659ea",
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter",
                        "openEntityManagerInViewInterceptorConfigurer",
                        "org.springframework.data.web.config.SpringDataWebConfiguration",
                        "endpointObjectMapperWebMvcConfigurer"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration",
                    "dependencies": []
                },
                "spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.observation.web.client.HttpClientObservationsAutoConfiguration$MeterFilterConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.web.client.HttpClientObservationsAutoConfiguration$MeterFilterConfiguration",
                    "dependencies": []
                },
                "localeCharsetMappingsCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration$LocaleCharsetMappingsCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/HttpEncodingAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration"
                    ]
                },
                "formContentFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.web.servlet.filter.OrderedFormContentFilter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration"
                    ]
                },
                "jsonMixinModuleEntries": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.jackson.JsonMixinModuleEntries",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$JacksonMixinConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4"
                    ]
                },
                "multipartConfigElement": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "jakarta.servlet.MultipartConfigElement",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/MultipartAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration"
                    ]
                },
                "requestContextFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]",
                    "dependencies": []
                },
                "defaultViewResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.view.InternalResourceViewResolver",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter"
                    ]
                },
                "org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$PersistenceManagedTypesConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$PersistenceManagedTypesConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration",
                    "dependencies": []
                },
                "routerFunctionMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.function.support.RouterFunctionMapping",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcConversionService",
                        "mvcResourceUrlProvider"
                    ]
                },
                "jacksonObjectMapperBuilder": {
                    "aliases": [],
                    "scope": "prototype",
                    "type": "org.springframework.http.converter.json.Jackson2ObjectMapperBuilder",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "standardJacksonObjectMapperBuilderCustomizer"
                    ]
                },
                "org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration",
                    "dependencies": []
                },
                "beansEndpoint": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.beans.BeansEndpoint",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/beans/BeansEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4"
                    ]
                },
                "spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskSchedulingProperties",
                    "dependencies": []
                },
                "pageableResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.PageableHandlerMethodArgumentResolver",
                    "resource": "class path resource [org/springframework/data/web/config/SpringDataWebConfiguration.class]",
                    "dependencies": [
                        "org.springframework.data.web.config.SpringDataWebConfiguration"
                    ]
                },
                "healthEndpointWebExtension": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.health.HealthEndpointWebExtension",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointWebExtensionConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration",
                        "healthContributorRegistry",
                        "healthEndpointGroups",
                        "management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties"
                    ]
                },
                "multipartResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.multipart.support.StandardServletMultipartResolver",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/MultipartAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration"
                    ]
                },
                "localeResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "handlerFunctionAdapter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.function.support.HandlerFunctionAdapter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration$WebEndpointServletConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration$WebEndpointServletConfiguration",
                    "dependencies": []
                },
                "requestMappingHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcContentNegotiationManager",
                        "mvcConversionService",
                        "mvcResourceUrlProvider"
                    ]
                },
                "webExposeExcludePropertyEndpointFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.expose.IncludeExcludeEndpointFilter",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
                    ]
                },
                "lifecycleProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.context.support.DefaultLifecycleProcessor",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/context/LifecycleAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration",
                        "spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration",
                    "dependencies": [
                        "environment"
                    ]
                },
                "requestMappingHandlerAdapter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcContentNegotiationManager",
                        "mvcConversionService",
                        "mvcValidator"
                    ]
                },
                "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonMixinConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonMixinConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jdbc.NamedParameterJdbcTemplateConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.NamedParameterJdbcTemplateConfiguration",
                    "dependencies": []
                },
                "tomcatMetricsBinder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.metrics.web.tomcat.TomcatMetricsBinder",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/web/tomcat/TomcatMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration",
                        "simpleMeterRegistry"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$DataSourcePoolMetadataMetricsConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$DataSourcePoolMetadataMetricsConfiguration",
                    "dependencies": []
                },
                "spring.transaction-org.springframework.boot.autoconfigure.transaction.TransactionProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.TransactionProperties",
                    "dependencies": []
                },
                "observationRestClientCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.metrics.web.client.ObservationRestClientCustomizer",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/web/client/RestClientObservationConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.web.client.RestClientObservationConfiguration",
                        "observationRegistry",
                        "management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties"
                    ]
                },
                "jvmHeapPressureMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.jvm.JvmHeapPressureMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration",
                    "dependencies": [
                        "server-org.springframework.boot.autoconfigure.web.ServerProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.data.jpa.repository.support.JpaEvaluationContextExtension": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.jpa.repository.support.JpaEvaluationContextExtension",
                    "dependencies": []
                },
                "sslMeterBinder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.ssl.SslMeterBinder",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/ssl/SslObservabilityAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.ssl.SslObservabilityAutoConfiguration",
                        "sslInfo",
                        "sslBundleRegistry"
                    ]
                },
                "welcomePageNotAcceptableHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.WelcomePageNotAcceptableHandlerMapping",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "mvcConversionService",
                        "mvcResourceUrlProvider"
                    ]
                },
                "spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.info.ProjectInfoProperties",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.observation.web.client.HttpClientObservationsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.web.client.HttpClientObservationsAutoConfiguration",
                    "dependencies": []
                },
                "endpointOperationParameterMapper": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.invoke.convert.ConversionServiceParameterValueMapper",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/EndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration"
                    ]
                },
                "infoEndpoint": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.info.InfoEndpoint",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/info/InfoEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration$MeterFilterConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration$MeterFilterConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration$JdbcTransactionManagerConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration$JdbcTransactionManagerConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$BootstrapExecutorConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$BootstrapExecutorConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration",
                    "dependencies": []
                },
                "metricsRepositoryMethodInvocationListenerBeanPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.data.MetricsRepositoryMethodInvocationListenerBeanPostProcessor",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/data/RepositoryMetricsAutoConfiguration.class]",
                    "dependencies": []
                },
                "sslBundleRegistry": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.ssl.DefaultSslBundleRegistry",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/ssl/SslAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration"
                    ]
                },
                "jpaVendorAdapter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration"
                    ]
                },
                "productionBean": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "java.lang.String",
                    "resource": "class path resource [io/theja/springprofiles/ProdOnlyConfig.class]",
                    "dependencies": [
                        "prodOnlyConfig"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration",
                    "dependencies": []
                },
                "classLoaderMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
                    ]
                },
                "observationRestTemplateCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.metrics.web.client.ObservationRestTemplateCustomizer",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/web/client/RestTemplateObservationConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.web.client.RestTemplateObservationConfiguration",
                        "observationRegistry",
                        "management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$ThreadPoolTaskExecutorBuilderConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$ThreadPoolTaskExecutorBuilderConfiguration",
                    "dependencies": []
                },
                "servletWebChildContextFactory": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.web.ManagementContextFactory",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/web/servlet/ServletManagementContextAutoConfiguration.class]",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration",
                    "dependencies": [
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "spring.ssl-org.springframework.boot.autoconfigure.ssl.SslProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.core.type.classreading.CachingMetadataReaderFactory",
                    "dependencies": []
                },
                "jacksonGeoModule": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.geo.GeoModule",
                    "resource": "class path resource [org/springframework/data/web/config/SpringDataJacksonConfiguration.class]",
                    "dependencies": [
                        "org.springframework.data.web.config.SpringDataJacksonConfiguration"
                    ]
                },
                "fileWatcher": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.ssl.FileWatcher",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/ssl/SslAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration",
                    "dependencies": []
                },
                "springDataWebSettings": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.config.SpringDataWebSettings",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/data/web/SpringDataWebAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration"
                    ]
                },
                "meterRegistryCloser": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration$MeterRegistryCloser",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration"
                    ]
                },
                "mvcContentNegotiationManager": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.accept.ContentNegotiationManager",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "sortResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.SortHandlerMethodArgumentResolver",
                    "resource": "class path resource [org/springframework/data/web/config/SpringDataWebConfiguration.class]",
                    "dependencies": [
                        "org.springframework.data.web.config.SpringDataWebConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.sql.init.DataSourceInitializationConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.sql.init.DataSourceInitializationConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$HikariDataSourceMetricsConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration$HikariDataSourceMetricsConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration",
                    "dependencies": []
                },
                "errorAttributes": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.web.servlet.error.DefaultErrorAttributes",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration"
                    ]
                },
                "httpRequestHandlerAdapter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "beanNameHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcConversionService",
                        "mvcResourceUrlProvider"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.observation.web.client.RestTemplateObservationConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.web.client.RestTemplateObservationConfiguration",
                    "dependencies": []
                },
                "spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.MultipartProperties",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.ssl.SslHealthContributorAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.ssl.SslHealthContributorAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration",
                    "dependencies": [
                        "spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties"
                    ]
                },
                "sslPropertiesSslBundleRegistrar": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.ssl.SslPropertiesBundleRegistrar",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/ssl/SslAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.ssl.SslAutoConfiguration",
                        "fileWatcher"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$AsyncConfigurerConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$AsyncConfigurerConfiguration",
                    "dependencies": []
                },
                "defaultMeterObservationHandler": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.observation.DefaultMeterObservationHandler",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/ObservationAutoConfiguration$MeterObservationHandlerConfiguration$OnlyMetricsMeterObservationHandlerConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$MeterObservationHandlerConfiguration$OnlyMetricsMeterObservationHandlerConfiguration",
                        "simpleMeterRegistry",
                        "management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration$Hikari": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration$Hikari",
                    "dependencies": []
                },
                "resourceHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.handler.SimpleUrlHandlerMapping",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcContentNegotiationManager",
                        "mvcConversionService",
                        "mvcResourceUrlProvider"
                    ]
                },
                "simpleControllerHandlerAdapter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.data.web.config.SpringDataJacksonConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.config.SpringDataJacksonConfiguration",
                    "dependencies": [
                        "springDataWebSettings"
                    ]
                },
                "simpleAsyncTaskSchedulerBuilder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.task.SimpleAsyncTaskSchedulerBuilder",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskSchedulingConfigurations$SimpleAsyncTaskSchedulerBuilderConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$SimpleAsyncTaskSchedulerBuilderConfiguration"
                    ]
                },
                "spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.context.LifecycleProperties",
                    "dependencies": []
                },
                "management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties",
                    "dependencies": []
                },
                "flashMapManager": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.support.SessionFlashMapManager",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "healthContributorRegistry": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.AutoConfiguredHealthContributorRegistry",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "healthEndpointGroups",
                        "sslHealthIndicator",
                        "diskSpaceHealthIndicator",
                        "pingHealthContributor",
                        "dbHealthContributor"
                    ]
                },
                "parameterNamesModule": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "com.fasterxml.jackson.module.paramnames.ParameterNamesModule",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$ParameterNamesModuleConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration"
                    ]
                },
                "propertiesObservationFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.PropertiesObservationFilterPredicate",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/ObservationAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration",
                        "management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties"
                    ]
                },
                "persistenceManagedTypes": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.orm.jpa.persistenceunit.SimplePersistenceManagedTypes",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/orm/jpa/JpaBaseConfiguration$PersistenceManagedTypesConfiguration.class]",
                    "dependencies": [
                        "org.springframework.beans.factory.support.DefaultListableBeanFactory@5d1659ea",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4"
                    ]
                },
                "micrometerClock": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.Clock$1",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration"
                    ]
                },
                "greetingService": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.theja.springprofiles.GreetingService",
                    "resource": "file [C:\\Users\\ktheja\\Work\\Code\\z\\spring-profiles\\target\\classes\\io\\theja\\springprofiles\\GreetingService.class]",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration",
                    "dependencies": []
                },
                "propertiesMeterFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.PropertiesMeterFilter",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/MetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration",
                        "management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
                    ]
                },
                "healthHttpCodeStatusMapper": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.health.SimpleHttpCodeStatusMapper",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
                        "management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration",
                    "dependencies": []
                },
                "metricsRepositoryMethodInvocationListener": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.metrics.data.MetricsRepositoryMethodInvocationListener",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/data/RepositoryMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.data.RepositoryMetricsAutoConfiguration",
                        "repositoryTagsProvider"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration",
                    "dependencies": []
                },
                "uptimeMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.system.UptimeMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/SystemMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration"
                    ]
                },
                "controllerExposeExcludePropertyEndpointFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.expose.IncludeExcludeEndpointFilter",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
                    ]
                },
                "pathMappedEndpoints": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.PathMappedEndpoints",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration",
                        "servletEndpointDiscoverer",
                        "webEndpointDiscoverer",
                        "controllerEndpointDiscoverer"
                    ]
                },
                "jvmThreadMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
                    ]
                },
                "diskSpaceMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.metrics.system.DiskSpaceMetricsBinder",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/SystemMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration",
                        "management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
                    ]
                },
                "org.springframework.data.web.config.ProjectingArgumentResolverRegistrar": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.config.ProjectingArgumentResolverRegistrar",
                    "dependencies": []
                },
                "managementServletContext": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration$$Lambda/0x00000259017e2e90",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/web/servlet/ServletManagementContextAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration",
                        "management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties"
                    ]
                },
                "fileDescriptorMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.system.FileDescriptorMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/SystemMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration"
                    ]
                },
                "org.springframework.data.jpa.util.JpaMetamodelCacheCleanup": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.jpa.util.JpaMetamodelCacheCleanup",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$AspectJAutoProxyingConfiguration$CglibAutoProxyConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$AspectJAutoProxyingConfiguration$CglibAutoProxyConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$MeterObservationHandlerConfiguration$OnlyMetricsMeterObservationHandlerConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$MeterObservationHandlerConfiguration$OnlyMetricsMeterObservationHandlerConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration",
                    "dependencies": [
                        "server-org.springframework.boot.autoconfigure.web.ServerProperties"
                    ]
                },
                "servletEndpointDiscoverer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointDiscoverer",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration$WebEndpointServletConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration$WebEndpointServletConfiguration",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4"
                    ]
                },
                "emBeanDefinitionRegistrarPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor",
                    "dependencies": []
                },
                "metricsHttpServerUriTagFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.config.MeterFilter$9",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/web/servlet/WebMvcObservationAutoConfiguration$MeterFilterConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration$MeterFilterConfiguration",
                        "management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties",
                        "management.metrics-org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties"
                    ]
                },
                "restClientBuilderConfigurer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/client/RestClientAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration"
                    ]
                },
                "eagerTaskExecutorMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.LazyInitializationExcludeFilter$$Lambda/0x00000259017eba60",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/task/TaskExecutorMetricsAutoConfiguration.class]",
                    "dependencies": []
                },
                "mvcValidator": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport$NoOpValidator",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration",
                    "dependencies": []
                },
                "applicationAvailability": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.availability.ApplicationAvailabilityBean",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/availability/ApplicationAvailabilityAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration",
                    "dependencies": []
                },
                "mvcResourceUrlProvider": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.resource.ResourceUrlProvider",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "healthEndpoint": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.health.HealthEndpoint",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
                        "healthContributorRegistry",
                        "healthEndpointGroups",
                        "management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration$EnableSameManagementContextConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration$SameManagementContextConfiguration$EnableSameManagementContextConfiguration",
                    "dependencies": []
                },
                "spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutionProperties",
                    "dependencies": []
                },
                "viewControllerHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.HandlerMapping",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcConversionService",
                        "mvcResourceUrlProvider"
                    ]
                },
                "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$PooledDataSourceConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$PooledDataSourceConfiguration",
                    "dependencies": []
                },
                "themeResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.theme.FixedThemeResolver",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.availability.AvailabilityHealthContributorAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.availability.AvailabilityHealthContributorAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration",
                    "dependencies": []
                },
                "sslInfo": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.info.SslInfo",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/ssl/SslHealthContributorAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.ssl.SslHealthContributorAutoConfiguration",
                        "sslBundleRegistry",
                        "management.health.ssl-org.springframework.boot.actuate.autoconfigure.ssl.SslHealthIndicatorProperties"
                    ]
                },
                "mvcPatternParser": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.util.pattern.PathPatternParser",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration",
                    "dependencies": [
                        "spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties"
                    ]
                },
                "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration$MvcAdditionalHealthEndpointPathsConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration$MvcAdditionalHealthEndpointPathsConfiguration",
                    "dependencies": []
                },
                "servletEndpointRegistrar": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.ServletEndpointRegistrar",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration$WebMvcServletEndpointManagementContextConfiguration",
                        "management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties",
                        "servletEndpointDiscoverer",
                        "dispatcherServletRegistration",
                        "propertiesEndpointAccessResolver"
                    ]
                },
                "org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor",
                    "dependencies": []
                },
                "dispatcherServlet": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.DispatcherServlet",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/DispatcherServletAutoConfiguration$DispatcherServletConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration",
                        "spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.task.TaskExecutorMetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.task.TaskExecutorMetricsAutoConfiguration",
                    "dependencies": [
                        "simpleMeterRegistry"
                    ]
                },
                "restClientBuilder": {
                    "aliases": [],
                    "scope": "prototype",
                    "type": "org.springframework.web.client.RestClient$Builder",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/client/RestClientAutoConfiguration.class]",
                    "dependencies": []
                },
                "greetingController": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.theja.springprofiles.GreetingController",
                    "resource": "file [C:\\Users\\ktheja\\Work\\Code\\z\\spring-profiles\\target\\classes\\io\\theja\\springprofiles\\GreetingController.class]",
                    "dependencies": [
                        "greetingService"
                    ]
                },
                "jvmInfoMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.jvm.JvmInfoMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration",
                    "dependencies": []
                },
                "webEndpointServletHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/servlet/WebMvcEndpointManagementContextConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration",
                        "webEndpointDiscoverer",
                        "servletEndpointDiscoverer",
                        "controllerEndpointDiscoverer",
                        "endpointMediaTypes",
                        "management.endpoints.web.cors-org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties",
                        "management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties",
                        "environment"
                    ]
                },
                "threadPoolTaskExecutorBuilder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.task.ThreadPoolTaskExecutorBuilder",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskExecutorConfigurations$ThreadPoolTaskExecutorBuilderConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$ThreadPoolTaskExecutorBuilderConfiguration",
                        "spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties"
                    ]
                },
                "hikariPoolDataSourceMetadataProvider": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration$$Lambda/0x00000259014c7df0",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jdbc/metadata/DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration"
                    ]
                },
                "prodOnlyConfig": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.theja.springprofiles.ProdOnlyConfig$$SpringCGLIB$$0",
                    "resource": "file [C:\\Users\\ktheja\\Work\\Code\\z\\spring-profiles\\target\\classes\\io\\theja\\springprofiles\\ProdOnlyConfig.class]",
                    "dependencies": []
                },
                "processorMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.system.ProcessorMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/SystemMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$SimpleAsyncTaskSchedulerBuilderConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$SimpleAsyncTaskSchedulerBuilderConfiguration",
                    "dependencies": [
                        "spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties"
                    ]
                },
                "spring.jdbc-org.springframework.boot.autoconfigure.jdbc.JdbcProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.JdbcProperties",
                    "dependencies": []
                },
                "springProfilesApplication": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.theja.springprofiles.SpringProfilesApplication",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.integration.IntegrationMetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.integration.IntegrationMetricsAutoConfiguration",
                    "dependencies": []
                },
                "transactionExecutionListeners": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.ExecutionListenersTransactionManagerCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/transaction/TransactionManagerCustomizationAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$MeterObservationHandlerConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$MeterObservationHandlerConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter",
                    "dependencies": [
                        "spring.web-org.springframework.boot.autoconfigure.web.WebProperties",
                        "spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties",
                        "org.springframework.beans.factory.support.DefaultListableBeanFactory@5d1659ea"
                    ]
                },
                "org.springframework.data.web.config.SpringDataWebConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.config.SpringDataWebConfiguration",
                    "dependencies": [
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4"
                    ]
                },
                "transactionManager": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.orm.jpa.JpaTransactionManager",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration"
                    ]
                },
                "errorPageRegistrarBeanPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.web.server.ErrorPageRegistrarBeanPostProcessor",
                    "dependencies": []
                },
                "propertiesEndpointAccessResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.PropertiesEndpointAccessResolver",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/EndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration",
                        "environment"
                    ]
                },
                "errorPageCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$ErrorPageCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration",
                        "dispatcherServletRegistration"
                    ]
                },
                "mvcConversionService": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.format.WebConversionService",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration",
                    "dependencies": [
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "spring.web-org.springframework.boot.autoconfigure.web.WebProperties"
                    ]
                },
                "openEntityManagerInViewInterceptorConfigurer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration$1",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/orm/jpa/JpaBaseConfiguration$JpaWebConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration",
                        "openEntityManagerInViewInterceptor"
                    ]
                },
                "controllerEndpointDiscoverer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointDiscoverer",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration"
                    ]
                },
                "diskSpaceHealthIndicator": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.system.DiskSpaceHealthIndicator",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/system/DiskSpaceHealthContributorAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration",
                        "management.health.diskspace-org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthIndicatorProperties"
                    ]
                },
                "tomcatWebServerFactoryCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/embedded/EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration",
                        "environment",
                        "server-org.springframework.boot.autoconfigure.web.ServerProperties"
                    ]
                },
                "jvmMemoryMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$OnlyMetricsConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration$OnlyMetricsConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration",
                    "dependencies": []
                },
                "restClientSsl": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.client.AutoConfiguredRestClientSsl",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/client/RestClientAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration",
                        "sslBundleRegistry"
                    ]
                },
                "threadPoolTaskSchedulerBuilder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.task.ThreadPoolTaskSchedulerBuilder",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskSchedulingConfigurations$ThreadPoolTaskSchedulerBuilderConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.task.TaskSchedulingConfigurations$ThreadPoolTaskSchedulerBuilderConfiguration",
                        "spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties"
                    ]
                },
                "spring.http.client-org.springframework.boot.autoconfigure.http.client.HttpClientProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.http.client.HttpClientProperties",
                    "dependencies": []
                },
                "viewNameTranslator": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration",
                    "dependencies": []
                },
                "mvcPathMatcher": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.util.AntPathMatcher",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration"
                    ]
                },
                "handlerExceptionResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.handler.HandlerExceptionResolverComposite",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcContentNegotiationManager"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration",
                    "dependencies": []
                },
                "basicErrorController": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration",
                        "errorAttributes"
                    ]
                },
                "pingHealthContributor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.health.PingHealthIndicator",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthContributorAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration"
                    ]
                },
                "dispatcherServletRegistration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration",
                        "dispatcherServlet",
                        "spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties"
                    ]
                },
                "pageableCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration$$Lambda/0x00000259017b60c8",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/data/web/SpringDataWebAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration"
                    ]
                },
                "dataSource": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "com.zaxxer.hikari.HikariDataSource",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceConfiguration$Hikari.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration$Hikari",
                        "spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties",
                        "jdbcConnectionDetails",
                        "environment"
                    ]
                },
                "sslHealthIndicator": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.ssl.SslHealthIndicator",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/ssl/SslHealthContributorAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.ssl.SslHealthContributorAutoConfiguration",
                        "sslInfo"
                    ]
                },
                "healthEndpointGroupMembershipValidator": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration$HealthEndpointGroupMembershipValidator",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration",
                        "management.endpoint.health-org.springframework.boot.actuate.autoconfigure.health.HealthEndpointProperties",
                        "healthContributorRegistry"
                    ]
                },
                "healthEndpointGroupsBeanPostProcessor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointConfiguration$HealthEndpointGroupsBeanPostProcessor",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointConfiguration.class]",
                    "dependencies": []
                },
                "management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$TaskExecutorConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$TaskExecutorConfiguration",
                    "dependencies": []
                },
                "tomcatServletWebServerFactory": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/ServletWebServerFactoryConfiguration$EmbeddedTomcat.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat"
                    ]
                },
                "org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration",
                    "dependencies": []
                },
                "spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jackson.JacksonProperties",
                    "dependencies": []
                },
                "error": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$StaticView",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/error/ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration",
                    "dependencies": [
                        "spring.data.web-org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties"
                    ]
                },
                "spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.DataSourceProperties",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration",
                    "dependencies": []
                },
                "namedParameterJdbcTemplate": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jdbc/NamedParameterJdbcTemplateConfiguration.class]",
                    "dependencies": [
                        "dataSourceScriptDatabaseInitializer",
                        "org.springframework.boot.autoconfigure.jdbc.NamedParameterJdbcTemplateConfiguration",
                        "jdbcTemplate"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration",
                    "dependencies": []
                },
                "simpleAsyncTaskExecutorBuilder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.task.SimpleAsyncTaskExecutorBuilder",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/task/TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.task.TaskExecutorConfigurations$SimpleAsyncTaskExecutorBuilderConfiguration"
                    ]
                },
                "jsonMixinModule": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.jackson.JsonMixinModule",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$JacksonMixinConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonMixinConfiguration",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "jsonMixinModuleEntries"
                    ]
                },
                "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration",
                    "dependencies": []
                },
                "jdbcConnectionDetails": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.PropertiesJdbcConnectionDetails",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceAutoConfiguration$PooledDataSourceConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$PooledDataSourceConfiguration",
                        "spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties"
                    ]
                },
                "spring.web-org.springframework.boot.autoconfigure.web.WebProperties": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.WebProperties",
                    "dependencies": []
                },
                "clientHttpRequestFactoryBuilder": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.http.client.JdkClientHttpRequestFactoryBuilder",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/http/client/HttpClientAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration"
                    ]
                },
                "jvmGcMetrics": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.core.instrument.binder.jvm.JvmGcMetrics",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/JvmMetricsAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration"
                    ]
                },
                "offsetResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.OffsetScrollPositionHandlerMethodArgumentResolver",
                    "resource": "class path resource [org/springframework/data/web/config/SpringDataWebConfiguration.class]",
                    "dependencies": [
                        "org.springframework.data.web.config.SpringDataWebConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$TransactionTemplateConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$TransactionTemplateConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration",
                    "dependencies": []
                },
                "healthEndpointWebMvcHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.web.servlet.AdditionalHealthEndpointPathsWebMvcHandlerMapping",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/health/HealthEndpointWebExtensionConfiguration$MvcAdditionalHealthEndpointPathsConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointWebExtensionConfiguration$MvcAdditionalHealthEndpointPathsConfiguration",
                        "webEndpointDiscoverer",
                        "healthEndpointGroups"
                    ]
                },
                "mvcViewResolver": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.servlet.view.ViewResolverComposite",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcContentNegotiationManager"
                    ]
                },
                "simpleConfig": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimplePropertiesConfigAdapter",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/metrics/export/simple/SimpleMetricsExportAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration",
                        "management.simple.metrics.export-org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.observation.web.client.RestClientObservationConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.observation.web.client.RestClientObservationConfiguration",
                    "dependencies": []
                },
                "welcomePageHandlerMapping": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.servlet.WelcomePageHandlerMapping",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6cce16f4",
                        "mvcConversionService",
                        "mvcResourceUrlProvider"
                    ]
                },
                "org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration",
                    "dependencies": []
                },
                "servletExposeExcludePropertyEndpointFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.expose.IncludeExcludeEndpointFilter",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/ServletEndpointManagementContextConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration",
                        "management.endpoints.web-org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration",
                    "dependencies": []
                },
                "observationRegistry": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "io.micrometer.observation.SimpleObservationRegistry",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/ObservationAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.ObservationAutoConfiguration"
                    ]
                },
                "mvcUriComponentsContributor": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.web.method.support.CompositeUriComponentsContributor",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration",
                        "mvcConversionService",
                        "requestMappingHandlerAdapter"
                    ]
                },
                "webAccessPropertiesOperationFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.endpoint.OperationFilter$$Lambda/0x00000259017d8470",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/web/WebEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration",
                        "propertiesEndpointAccessResolver"
                    ]
                },
                "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration",
                    "dependencies": []
                },
                "endpointObjectMapper": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.jackson.JacksonEndpointAutoConfiguration$$Lambda/0x0000025901786310",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/endpoint/jackson/JacksonEndpointAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.endpoint.jackson.JacksonEndpointAutoConfiguration"
                    ]
                },
                "jacksonObjectMapper": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "com.fasterxml.jackson.databind.ObjectMapper",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/jackson/JacksonAutoConfiguration$JacksonObjectMapperConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration",
                        "jacksonObjectMapperBuilder"
                    ]
                },
                "jpaSharedEM_entityManagerFactory": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "jdk.proxy2.$Proxy120",
                    "dependencies": [
                        "entityManagerFactory"
                    ]
                },
                "webMvcObservationFilter": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.web.servlet.FilterRegistrationBean",
                    "resource": "class path resource [org/springframework/boot/actuate/autoconfigure/observation/web/servlet/WebMvcObservationAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.actuate.autoconfigure.observation.web.servlet.WebMvcObservationAutoConfiguration",
                        "observationRegistry",
                        "management.observations-org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties"
                    ]
                },
                "clientHttpRequestFactorySettings": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.http.client.ClientHttpRequestFactorySettings",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/http/client/HttpClientAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration"
                    ]
                },
                "httpMessageConvertersRestClientCustomizer": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.web.client.HttpMessageConvertersRestClientCustomizer",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/web/client/RestClientAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration"
                    ]
                },
                "pageModule": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.data.web.config.SpringDataJacksonConfiguration$PageModule",
                    "resource": "class path resource [org/springframework/data/web/config/SpringDataJacksonConfiguration.class]",
                    "dependencies": [
                        "org.springframework.data.web.config.SpringDataJacksonConfiguration"
                    ]
                },
                "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateConfiguration",
                    "dependencies": []
                },
                "org.springframework.boot.actuate.autoconfigure.endpoint.jackson.JacksonEndpointAutoConfiguration": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.actuate.autoconfigure.endpoint.jackson.JacksonEndpointAutoConfiguration",
                    "dependencies": []
                },
                "platformTransactionManagerCustomizers": {
                    "aliases": [],
                    "scope": "singleton",
                    "type": "org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers",
                    "resource": "class path resource [org/springframework/boot/autoconfigure/transaction/TransactionManagerCustomizationAutoConfiguration.class]",
                    "dependencies": [
                        "org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizationAutoConfiguration"
                    ]
                }
            }
        }
    }
}

 */

