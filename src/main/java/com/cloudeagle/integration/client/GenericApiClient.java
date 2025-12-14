package com.cloudeagle.integration.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GenericApiClient {

    private final WebClient client = WebClient.create();

    public String call(String baseUrl, String path, String token) {
        return client.get()
                .uri(baseUrl + path)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
