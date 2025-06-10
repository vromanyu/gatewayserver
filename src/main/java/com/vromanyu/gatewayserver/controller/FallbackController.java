package com.vromanyu.gatewayserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/contact-support")
    public Mono<String> contactSupport() {
        return Mono.just("An error occurred. Please try after some time or contact the support");
    }
}
