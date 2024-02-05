package dev.dflachbart.sampleservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration(proxyBeanMethods = false)
public class AppConfig {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean("WebClient")
    public WebClient webClient() {
        return webClientBuilder.build();
    }
}
