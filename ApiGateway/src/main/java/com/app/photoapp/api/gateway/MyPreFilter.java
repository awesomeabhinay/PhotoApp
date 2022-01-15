package com.app.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;
@Component
public class MyPreFilter implements GlobalFilter, Ordered {

    final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);
    @Order(4)
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("My first pre-filter is executed...");

        String requestPath = exchange.getRequest().getPath().toString();
        logger.info("request path: " + requestPath);
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        Set<String> headersName = httpHeaders.keySet();
        headersName.forEach(header -> {
            logger.info(headersName + ": " + httpHeaders.getFirst(header));
        });
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
