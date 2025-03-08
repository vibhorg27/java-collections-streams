package com.bridgelabz.collections.queueinterface;

import java.util.*;
public class GenerateBinary {
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");

        for (int i = 0; i < n; i++) {
            String binary = queue.poll();

            result.add(binary);
            queue.offer(binary + "0");

            queue.offer(binary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateBinaryNumbers(5));
    }
}

