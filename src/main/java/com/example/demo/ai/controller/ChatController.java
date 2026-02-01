package com.example.demo.ai.controller;

import com.example.demo.ai.model.ChatRequest;
import com.example.demo.ai.model.QnaRequest;
import com.example.demo.ai.model.res.GeminiResponse;
import com.example.demo.ai.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public GeminiResponse chat(@RequestBody ChatRequest request) {
        return chatService.chat(request.getQuestion());
    }

    @PostMapping("/store")
    public ResponseEntity<String> create(@RequestBody QnaRequest request) {
        chatService.store(request);
        return ResponseEntity.ok("Stored successfully");
    }
}
