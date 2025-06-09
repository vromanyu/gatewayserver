package com.vromanyu.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
      .addResponseHeader("X-Response-Time", (LocalDateTime.now(ZoneOffset.UTC).toString())))
    .uri("lb://ACCOUNTS"))
   .route(p -> p.path("/ms/loans/**")
    .filters(f ->
     f.rewritePath("/ms/loans/(?<segment>.*)", "/${segment}")
      .addResponseHeader("X-Response-Time", (LocalDateTime.now(ZoneOffset.UTC).toString())))
    .uri("lb://LOANS"))
   .route(p -> p.path("/ms/cards/**")
    .filters(f ->
     f.rewritePath("/ms/cards/(?<segment>.*)", "/${segment}")
      .addResponseHeader("X-Response-Time", (LocalDateTime.now(ZoneOffset.UTC).toString())))
    .uri("lb://CARDS")).build();
 }
}
