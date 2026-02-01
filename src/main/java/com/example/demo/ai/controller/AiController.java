package com.example.demo.ai.controller;

import com.example.demo.ai.client.LlmClient;
import com.example.demo.ai.model.res.GeminiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    LlmClient llmClient;

    @GetMapping("/text/{text}")
    public GeminiResponse getAiText(@PathVariable("text") String text){
        return llmClient.getText(text);

//        return aiService.getText("Explain the theory of relativity in simple terms.");

    }

}
