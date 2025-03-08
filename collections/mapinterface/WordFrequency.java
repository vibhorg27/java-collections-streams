package com.bridgelabz.collections.mapinterface;

import java.util.*;

public class WordFrequency {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();

        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        for (String word : text.split("\\s+")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        System.out.println(countWords(text));
    }
}

