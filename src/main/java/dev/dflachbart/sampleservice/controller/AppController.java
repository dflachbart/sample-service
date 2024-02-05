package dev.dflachbart.sampleservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class AppController {

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    private final WebClient webClient;

    public AppController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/test")
    String test() {
        logger.info("test called");

        return webClient
                .get()
                .uri("http://icanhazip.com")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
