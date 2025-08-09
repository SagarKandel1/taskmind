package com.example.taskmind.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class OpenAIService {

    @Value("${openai.api.key:}")
    private String apiKey;

    private final WebClient webClient;

    public OpenAIService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .build();
    }

    public Mono<String> generateTaskSuggestion(String prompt) {
        if (apiKey == null || apiKey.isBlank()) {
            return Mono.error(new IllegalStateException("OpenAI API key is not set. Please set openai.api.key in application.properties."));
        }

        String requestBody = String.format("""
        {
          "model": "gpt-4o-mini",
          "messages": [
            {"role": "system", "content": "You are a helpful assistant that suggests clear, actionable tasks."},
            {"role": "user", "content": "%s"}
          ],
          "max_tokens": 150
        }
        """, escapeJson(prompt));

        return webClient.post()
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, e -> Mono.just(e.getResponseBodyAsString()));
    }

    private static String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
    }
}
