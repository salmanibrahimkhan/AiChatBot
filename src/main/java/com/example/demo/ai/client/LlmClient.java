package com.example.demo.ai.client;

import com.example.demo.ai.model.res.GeminiResponse;
import com.example.demo.ai.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LlmClient {

    private final RestTemplate restTemplate = new RestTemplate();

//    @Value("${openai.api.key}")
//    private String apiKey;
//
//    @Value("${openai.api.url}")
//    private String apiUrl;

    @Autowired
    AiService aiService;

    public GeminiResponse callLlm(String prompt) {

        return aiService.getText(prompt);
    }
}
