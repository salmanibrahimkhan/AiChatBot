package com.example.demo.ai.util;

import java.util.*;

public class CosineSimilarityUtil {

    public static double cosineSimilarity(List<String> text1, List<String> text2) {
        Map<String, Integer> freq1 = buildFrequencyMap(text1);
        Map<String, Integer> freq2 = buildFrequencyMap(text2);

        Set<String> allWords = new HashSet<>();
        allWords.addAll(freq1.keySet());
        allWords.addAll(freq2.keySet());

        int dotProduct = 0;
        double norm1 = 0;
        double norm2 = 0;

        for (String word : allWords) {
            int v1 = freq1.getOrDefault(word, 0);
            int v2 = freq2.getOrDefault(word, 0);

            dotProduct += v1 * v2;
            norm1 += Math.pow(v1, 2);
            norm2 += Math.pow(v2, 2);
        }

        if (norm1 == 0 || norm2 == 0) return 0.0;

        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }

    private static Map<String, Integer> buildFrequencyMap(List<String> words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }
}
