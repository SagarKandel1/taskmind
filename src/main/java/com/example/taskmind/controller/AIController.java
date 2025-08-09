package com.example.taskmind.controller;

import com.example.taskmind.service.OpenAIService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/ai")
@Validated
public class AIController {

    private final OpenAIService openAIService;

    public AIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping(value = "/suggest-task", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> suggestTask(@RequestBody SuggestRequest request) {
        return openAIService.generateTaskSuggestion(request.getPrompt());
    }

    public static class SuggestRequest {
        @NotBlank
        private String prompt;

        public String getPrompt() {
            return prompt;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }
    }
}
