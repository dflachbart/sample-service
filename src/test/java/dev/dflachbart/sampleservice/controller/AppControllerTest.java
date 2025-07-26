package dev.dflachbart.sampleservice.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

class AppControllerTest {
    @Test
    void testTestEndpoint() {
        // Arrange
        WebClient webClient = Mockito.mock(WebClient.class);
        RequestHeadersUriSpec uriSpec = Mockito.mock(RequestHeadersUriSpec.class);
        RequestHeadersSpec headersSpec = Mockito.mock(RequestHeadersSpec.class);
        ResponseSpec responseSpec = Mockito.mock(ResponseSpec.class);

        Mockito.when(webClient.get()).thenReturn(uriSpec);
        Mockito.when(uriSpec.uri(anyString())).thenReturn(headersSpec);
        Mockito.when(headersSpec.retrieve()).thenReturn(responseSpec);
        Mockito.when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just("1.2.3.4\n"));

        AppController controller = new AppController(webClient);

        // Act
        String result = controller.test();

        // Assert
        assertEquals("1.2.3.5\n", result);
    }
}

