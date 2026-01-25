package com.example.demo.ai.repository;


import com.example.demo.ai.model.Faq;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FaqRepository {

    public List<Faq> findAll() {
        return List.of(
            new Faq("How can I reset my password?",
                    "Click on 'Forgot Password' and follow the steps.")
//            new Faq("What is the refund policy?",
//                    "Refunds are processed within 7 working days."),
//            new Faq("How to contact customer support?",
//                    "You can contact customer support via email or phone.")
        );
    }
}
