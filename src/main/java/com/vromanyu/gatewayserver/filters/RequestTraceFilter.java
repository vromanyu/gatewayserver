//package com.vromanyu.gatewayserver.filters;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.UUID;
//
//
//@Order(1)
//@Component
//@Slf4j
//public class RequestTraceFilter implements GlobalFilter {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        var headers = exchange.getRequest().getHeaders();
//        if (isCorrelationIdPresent(headers)) {
//            log.debug("correlation id ({}) present", FilterUtility.getCorrelationId(headers));
//        } else {
//            String correlationId = generateCorrelationId();
//            exchange = FilterUtility.setCorrelationId(exchange, correlationId);
//            log.debug("correlation id: ({}) generated", correlationId);
//        }
//        return chain.filter(exchange);
//    }
//
//    private boolean isCorrelationIdPresent(HttpHeaders headers) {
//        return FilterUtility.getCorrelationId(headers) != null;
//    }
//
//    private String generateCorrelationId() {
//        return UUID.randomUUID().toString();
//    }
//}
