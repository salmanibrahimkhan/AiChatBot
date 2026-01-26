package com.example.demo.ai.controller;

import com.example.demo.ai.model.res.GeminiResponse;
import com.example.demo.ai.service.AiService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    AiService aiService;

    @GetMapping("/text/{text}")
    public GeminiResponse getAiText(@PathVariable("text") String text){
        return aiService.getText(text);

//        return aiService.getText("Explain the theory of relativity in simple terms.");

    }

}
