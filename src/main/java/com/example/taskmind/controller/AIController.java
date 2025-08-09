package com.example.taskmind.controller;

import com.example.taskmind.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    // Inject the OpenAIService so we can call the AI API from this controller
    @Autowired
    private OpenAIService openAIService;

    // Define a POST endpoint at /api/ai/suggest-task
    // It consumes a JSON body and returns JSON
    @PostMapping(value = "/suggest-task", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> suggestTask(@RequestBody PromptRequest promptRequest) {
        // Call the OpenAIService with the user's prompt
        // This returns a Mono<String> which is a reactive async response
        return openAIService.generateTaskSuggestion(promptRequest.getPrompt());
    }

    // A simple inner class to map the incoming JSON body to a Java object
    // It expects JSON like { "prompt": "your prompt here" }
    public static class PromptRequest {
        private String prompt;

        // Getter for 'prompt' (needed for Spring to map JSON)
        public String getPrompt() {
            return prompt;
        }

        // Setter for 'prompt'
        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }
    }
}
