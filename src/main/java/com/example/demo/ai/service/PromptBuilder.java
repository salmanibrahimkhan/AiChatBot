package com.example.demo.ai.service;

import com.example.demo.ai.model.Faq;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PromptBuilder {

    public static String buildPrompt(List<Faq> faqs, String userQuestion) {

        StringBuilder sb = new StringBuilder();

//        sb.append("""
//        You are a customer support assistant.
//        Answer the user's question using ONLY the FAQs below.
//        If the answer is not found, reply exactly:
//        "Sorry, I don't have that information."
//
//        FAQs:
//        """);
        sb.append("""
                You are a customer support assistant.
                Rules:
                1. Do NOT invent information or use external knowledge.
                2. First, try to find an exact match in the FAQs.
                3. If no exact match exists, find the MOST RELATABLE and SEMANTICALLY CLOSE question from the FAQs.
                4. Return ONLY the answer of the best matching FAQ.
                5. If the user's question is completely unrelated to all FAQs, reply exactly:
                   "Sorry, I don't have that information.
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
