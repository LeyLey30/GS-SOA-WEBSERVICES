package com.conciliar.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ExternalIntegrationService {
    private final WebClient client;
    public ExternalIntegrationService(WebClient client) { this.client = client; }

    public Mono<String> getTip() {
        return client.get().uri("/entries").retrieve().bodyToMono(Map.class).map(m -> "Keep focused: 25 min blocks");
    }
}
