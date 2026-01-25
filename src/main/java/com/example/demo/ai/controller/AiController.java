package com.example.demo.ai.controller;

import com.example.demo.ai.model.res.GeminiResponse;
import com.example.demo.ai.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    AiService aiService;

    @GetMapping("/text")
    public GeminiResponse getAiText(){
        String str = """
                "You are a customer support assistant.
                Answer the user's question using ONLY the FAQs below.
                If the answer is not found, say "Sorry, I don't have that information."
                
                FAQs:
                1. How can I reset my password?
                Answer: Click on 'Forgot Password' and follow the steps.
                
                User Question:
                How can I reset my password?"
                """;
        str = "How can I reset my password?";
        return aiService.getText(str);

//        return aiService.getText("Explain the theory of relativity in simple terms.");

    }

}
