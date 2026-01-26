package com.example.demo.ai.service;

import com.example.demo.ai.model.Faq;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PromptBuilder {

    public static String buildPrompt(List<Faq> faqs, String userQuestion) {

        StringBuilder sb = new StringBuilder();

        sb.append("""
        You are a customer support assistant.
        Answer the user's question using ONLY the FAQs below.
        If the answer is not found, reply exactly:
        "Sorry, I don't have that information."
        
        FAQs:
        """);

        for (int i = 0; i < faqs.size(); i++) {
            Faq faq = faqs.get(i);
            sb.append(i + 1).append(". ")
              .append(faq.getQuestion()).append("\n")
              .append("Answer: ")
              .append(faq.getAnswer()).append("\n\n");
        }

        sb.append("User Question:\n")
          .append(userQuestion);

        return sb.toString();
    }
}
