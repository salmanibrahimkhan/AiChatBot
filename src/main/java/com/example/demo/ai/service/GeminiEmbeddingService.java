package com.example.demo.ai.service;

import com.example.demo.ai.client.LlmClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeminiEmbeddingService {

    @Autowired
    LlmClient llmClient;
    public float[] generateEmbedding(String text) {
        return llmClient.generateEmbedding(text);
    }
}
