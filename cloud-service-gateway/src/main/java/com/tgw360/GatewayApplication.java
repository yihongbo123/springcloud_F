package com.tgw360;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;

/**
 * Created by 易弘博 on 2018/4/16 13:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class GatewayApplication {
    @Bean
    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient,null);
    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
