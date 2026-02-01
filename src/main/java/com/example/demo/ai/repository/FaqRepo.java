package com.example.demo.ai.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FaqRepo {
    @Autowired
    EntityManager em;

    @Transactional
    public void insert(String question, String answer, String vectorStr) {

        em.createNativeQuery("""
            INSERT INTO faqs(question, answer, embedding)
            VALUES (?1, ?2, CAST(?3 AS vector))
        """)
                .setParameter(1, question)
                .setParameter(2, answer)
                .setParameter(3, vectorStr)
                .executeUpdate();
    }
}
