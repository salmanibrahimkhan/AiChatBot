package com.example.demo.ai.service;


import com.example.demo.ai.model.Content;
import com.example.demo.ai.model.GeminiRequest;
import com.example.demo.ai.model.Part;
import com.example.demo.ai.model.res.GeminiResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class AiService {

    private final WebClient webClient;

//    @Value("${app.ai.gemini.api-key:}")
    public String geminiApiKey = "AIzaSyDZlTonAtqPnM1a7vUxoWMjNSLLse-m8Mw";


    public AiService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-3-flash-preview:generateContent")
//                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent")
                .defaultHeader("x-goog-api-key", geminiApiKey)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public GeminiResponse getText(String text) {
        GeminiRequest requestBody = new GeminiRequest(List.of(new Content(List.of(new Part(text)))));
        System.out.println("requestBody : " + requestBody);
        GeminiResponse response= null;
        try{
            response = webClient.post()
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(GeminiResponse.class)
                    .block();
        }catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
        return response;
    }
}

// String requestBody = String.format("""
//        {
//          "contents": [
//            {
//              "parts": [
//                {
//                  "text": "%s"
//                }
//              ]
//            }
//          ]
//        }
//        """, prompt);