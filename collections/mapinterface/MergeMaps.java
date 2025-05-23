package com.bridgelabz.collections.mapinterface;

import java.util.*;

public class MergeMaps {
    public static Map<String, Integer> merge(Map<String, Integer> map1, Map<String, Integer> map2) {

        Map<String, Integer> merged = new HashMap<>(map1);

        for (var entry : map2.entrySet()) {

            merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return merged;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);

        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);

        System.out.println(merge(map1, map2));
    }
}

