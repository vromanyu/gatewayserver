//package com.vromanyu.gatewayserver.filters;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Order(2)
//@Component()
//@Slf4j
//public class ResponseTraceFilter implements GlobalFilter {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//            var headers = exchange.getRequest().getHeaders();
//            var correlationId = FilterUtility.getCorrelationId(headers);
//            log.debug("correlationId in response: {}", correlationId);
//            log.debug("reset correlationId in response: {}", correlationId);
//            exchange.getRequest().getHeaders().add(FilterUtility.CORRELATION_ID, correlationId);
//        }));
//    }
//}
