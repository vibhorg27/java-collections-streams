package com.bridgelabz.collections.listinterface;

import java.util.*;
import java.util.List;
import java.util.Map;

public class FindFrequency {
    public static Map<String, Integer> getFrequency(List<String> s){
        Map<String, Integer> frequencyMap = new HashMap<>();

        for(String word : s){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> string = Arrays.asList("vib", "han", "vib", "rat", "han");
        Map<String, Integer> result = getFrequency(string);
        System.out.println(result);
    }
}
