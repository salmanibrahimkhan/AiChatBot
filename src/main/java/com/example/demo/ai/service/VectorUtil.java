package com.example.demo.ai.service;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VectorUtil {

//    public static String toPgVector(float[] vector) {
//        return Arrays.stream(vector)
//                .mapToObj(Float::toString)
//                .collect(Collectors.joining(",", "[", "]"));
//    }

    public static String toPgVector(float[] vectors) {
        if (vectors == null || vectors.length == 0) {
            return "[]";
        }
        return IntStream.range(0, vectors.length)
                .mapToObj(i -> Float.toString(vectors[i]))
                .collect(Collectors.joining(",", "[", "]"));
    }
}
