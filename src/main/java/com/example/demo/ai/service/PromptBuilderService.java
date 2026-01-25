package com.example.demo.ai.service;

import com.example.demo.ai.model.Faq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptBuilderService {

    public String buildPrompt(List<Faq> faqs, String userQuestion) {

        StringBuilder prompt = new StringBuilder();

        prompt.append("""
            You are a customer support assistant.
            Answer the user's question using ONLY the FAQs below.
            If the answer is not found, say "Sorry, I don't have that information."
            
            FAQs:
            """);

        for (int i = 0; i < faqs.size(); i++) {
            Faq faq = faqs.get(i);
            prompt.append(i + 1).append(". ")
                  .append(faq.getQuestion()).append("\n")
                  .append("Answer: ").append(faq.getAnswer()).append("\n\n");
        }

        prompt.append("User Question:\n")
              .append(userQuestion);

        return prompt.toString();
    }
}
