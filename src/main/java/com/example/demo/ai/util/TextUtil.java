package com.example.demo.ai.util;

import java.util.Arrays;
import java.util.List;

public class TextUtil {

    public static List<String> tokenize(String text) {
        return Arrays.stream(
                text.toLowerCase()
                    .replaceAll("[^a-z ]", "")
                    .split("\\s+")
            )
            .filter(word -> word.length() > 2)
            .toList();
    }
}
