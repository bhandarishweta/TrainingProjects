package org.example.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder)
    {
        return builder.routes().route("Service1", r -> r.path("/api/v1/**").uri("http://localhost:8081"))
				.route("Service2", r -> r.path("/api/v1/**").uri("http://localhost:8082"))
//				.route("AuthMSRoute", r -> r.path("api/v1/**").uri("http://localhost:8083"))
//				.route("CategoryMSRoute", r -> r.path("api/v1/**").uri("lb://CATEGORY-SERVICE"))
                .build();
    }
}
