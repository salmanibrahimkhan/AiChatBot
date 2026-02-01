package com.example.demo.ai.client;

import com.example.demo.ai.model.Content;
import com.example.demo.ai.model.GeminiRequest;
import com.example.demo.ai.model.Part;
import com.example.demo.ai.model.res.GeminiResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class LlmClient {
    private final WebClient webClient;

//    public String geminiApiKey = "AIzaSyBBgQFakVSaGn59xttvaur4zD1KvOuRGDg";
      public String geminiApiKey = "AIzaSyB1VPn356G4ycOZsZIEfOQKluXO3i_Db5M";

    public LlmClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-3-flash-preview:generateContent")
//                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-lite:generateContent")
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
        System.out.println("response : " + response);
        return response;
    }

    public GeminiResponse callLlm(String prompt) {
        return getText(prompt);
    }

    public float[] generateEmbedding(String question) {
        try{
//            String prompt = """
//        Generate a semantic embedding for the following text.
//        The embedding should capture meaning for question-answer retrieval.
//        Text:
//        %s
//        """.formatted(question);

            String prompt = """
        Generate a semantic embedding for the following text.
        The embedding should capture meaning for question-answer retrieval.
        Text:
        What is java?
            """;

            float[] embeddingVector = webClient.post()
                    .bodyValue(prompt)
                    .retrieve()
                    .bodyToMono(float[].class)
                    .block();

            return embeddingVector != null ? embeddingVector : new float[0];
        }catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
            return new float[0];
        }
    }
}
