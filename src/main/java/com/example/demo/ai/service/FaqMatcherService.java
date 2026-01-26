package com.example.demo.ai.service;

import com.example.demo.ai.model.Faq;
import com.example.demo.ai.repository.FaqRepository;
import com.example.demo.ai.util.CosineSimilarityUtil;
import com.example.demo.ai.util.TextUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FaqMatcherService {

    private final FaqRepository repository;

    public FaqMatcherService(FaqRepository repository) {
        this.repository = repository;
    }

    public List<Faq> findRelevantFaqs(String userQuestion) {

        List<String> userTokens = TextUtil.tokenize(userQuestion);

        return repository.findAll().stream()
            .map(faq -> {
                List<String> faqTokens = TextUtil.tokenize(faq.getQuestion());
                double score = CosineSimilarityUtil.cosineSimilarity(userTokens, faqTokens);
                return Map.entry(faq, score);
            })
            .filter(entry -> entry.getValue() > 0.2) // threshold
            .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
            .limit(3)
            .map(Map.Entry::getKey)
            .toList();
    }
}
