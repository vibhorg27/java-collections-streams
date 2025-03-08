package com.bridgelabz.collections.mapinterface;

import java.util.*;

public class MaxValueFinder {
    public static String findMaxKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (var entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {

                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println(findMaxKey(map));
    }
}

