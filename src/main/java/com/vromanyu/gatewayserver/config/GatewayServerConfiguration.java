package com.vromanyu.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Configuration
public class GatewayServerConfiguration {

 @Bean
 public RouteLocator routeLocator(RouteLocatorBuilder builder) {
  return builder.routes()
   .route(p -> p.path("/ms/accounts/**")
    .filters(f ->
     f.rewritePath("/ms/accounts/(?<segment>.*)", "/${segment}")
      .addResponseHeader("X-Response-Time", (LocalDateTime.now(ZoneOffset.UTC).toString()))
             .circuitBreaker((config -> {
              config.setName("accountsCircuitBreaker");
              config.setFallbackUri("forward:/contact-support");
             })))
    .uri("lb://ACCOUNTS"))
   .route(p -> p.path("/ms/loans/**")
    .filters(f ->
     f.rewritePath("/ms/loans/(?<segment>.*)", "/${segment}")
      .addResponseHeader("X-Response-Time", (LocalDateTime.now(ZoneOffset.UTC).toString()))
             .retry(config -> config.setRetries(5).setMethods(HttpMethod.GET).setBackoff(Duration.ofMillis(500), Duration.ofMillis(1000), 2, true)))
    .uri("lb://LOANS"))
   .route(p -> p.path("/ms/cards/**")
    .filters(f ->
     f.rewritePath("/ms/cards/(?<segment>.*)", "/${segment}")
      .addResponseHeader("X-Response-Time", (LocalDateTime.now(ZoneOffset.UTC).toString())))
    .uri("lb://CARDS")).build();
 }
}
