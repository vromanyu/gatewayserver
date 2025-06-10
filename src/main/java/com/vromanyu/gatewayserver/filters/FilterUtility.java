//package com.vromanyu.gatewayserver.filters;
//
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.server.ServerWebExchange;
//
//import java.util.Objects;
//
//public final class FilterUtility {
//
//    private FilterUtility() {}
//
//    public static final String CORRELATION_ID = "correlationId-test";
//
//    public static String getCorrelationId(HttpHeaders headers) {
//        if (headers.get(CORRELATION_ID) != null) {
//            var requestHeaders = headers.get(CORRELATION_ID);
//            return Objects.requireNonNull(requestHeaders).getFirst();
//        } else {
//            return null;
//        }
//    }
//
//    public static ServerWebExchange setRequestHeader(ServerWebExchange exchange, String key, String value) {
//        return exchange.mutate().request(exchange.getRequest().mutate().header(key, value).build()).build();
//    }
//
//    public static ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
//        return setRequestHeader(exchange, correlationId, CORRELATION_ID);
//    }
//}
