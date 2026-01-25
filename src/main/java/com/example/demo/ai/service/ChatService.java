package com.example.demo.ai.service;

import com.example.demo.ai.client.LlmClient;
import com.example.demo.ai.model.ChatResponse;
import com.example.demo.ai.model.Faq;
import com.example.demo.ai.model.res.GeminiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final FaqService faqService;
    private final PromptBuilderService promptBuilderService;
    private final LlmClient llmClient;

    public ChatService(
            FaqService faqService,
            PromptBuilderService promptBuilderService,
            LlmClient llmClient) {
        this.faqService = faqService;
        this.promptBuilderService = promptBuilderService;
        this.llmClient = llmClient;
    }

    public GeminiResponse chat(String question) {

        List<Faq> faqs = faqService.getAllFaqs();
        String prompt = promptBuilderService.buildPrompt(faqs, question);
        return llmClient.callLlm(prompt);
    }
}
