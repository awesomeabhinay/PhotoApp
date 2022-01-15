package com.app.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterConfig {

    final Logger logger = LoggerFactory.getLogger(GlobalFilterConfig.class);

    @Order(2)
    @Bean
    public GlobalFilter secondFilter(){
        return ((exchange, chain) -> {
            logger.info("My 2nd pre filter called...");
            return chain.filter(exchange).then(Mono.fromRunnable(() ->{
                logger.info("My 2nd last filter");
            }));
        });
    }

    @Order(1)
    @Bean
    public GlobalFilter thirdFilter(){
        return ((exchange, chain) -> {
            logger.info("My 3rd pre filter called...");
            return chain.filter(exchange).then(Mono.fromRunnable(() ->{
                logger.info("My 3rd last filter");
            }));
        });
    }
}
