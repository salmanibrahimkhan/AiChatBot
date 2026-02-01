package com.example.demo.ai.service;

import com.example.demo.ai.client.LlmClient;
import com.example.demo.ai.model.ChatResponse;
import com.example.demo.ai.model.Faq;
import com.example.demo.ai.model.QnaRequest;
import com.example.demo.ai.model.res.GeminiResponse;
import com.example.demo.ai.repository.FaqRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ChatService {

//    private final FaqService faqService;
    private final PromptBuilder promptBuilder;
    private final LlmClient llmClient;
 //   private final FaqMatcherService matcherService;

    @Autowired
    FaqRepo repository;

    @Autowired
    GeminiEmbeddingService embeddingService;

//    public ChatService(
//            FaqService faqService,
//            PromptBuilder promptBuilder,
//            LlmClient llmClient,
//            FaqMatcherService matcherService) {
//        this.faqService = faqService;
//        this.promptBuilder = promptBuilder;
//        this.llmClient = llmClient;
//        this.matcherService = matcherService;
//    }

        public ChatService(
//            FaqService faqService,
            PromptBuilder promptBuilder,
            LlmClient llmClient) {
//        this.faqService = faqService;
        this.promptBuilder = promptBuilder;
        this.llmClient = llmClient;
    }

//    public GeminiResponse chat(String question) {
//        List<Faq> faqs = faqService.getAllFaqs();
//        String prompt = promptBuilder.buildPrompt(faqs, question);
//        return llmClient.callLlm(prompt);
//    }


    public GeminiResponse chat(String userQuestion) {

//        List<Faq> relevantFaqs; = matcherService.findRelevantFaqs(userQuestion);
        List<Faq> relevantFaqs =Collections.emptyList();

        if (relevantFaqs.isEmpty()) {
            return new GeminiResponse(); //"Sorry, I don't have that information.";
        }

        String prompt = PromptBuilder.buildPrompt(relevantFaqs, userQuestion);

        return llmClient.callLlm(prompt);
    }

    @Transactional
    public void store(QnaRequest req) {
        float[] embedding =
                embeddingService.generateEmbedding(req.question);
        System.out.println("Question : " + req.question + ", Generated embedding: " + embedding);
        String vectorStr = VectorUtil.toPgVector(embedding);

        repository.insert(
                req.question,
                req.answer,
                vectorStr
        );
    }
}

