package com.bridgelabz.collections.listinterface;

import java.util.LinkedList;

public class NthFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            return "Invalid input";
        }

        int firstIndex = 0;
        int secondIndex = 0;

        var first = list.listIterator();
        var second = list.listIterator();

        // Move 'first' N steps ahead
        while (firstIndex < n) {
            if (!first.hasNext()) {
                return "N is larger than the list size";
            }
            first.next();
            firstIndex++;
        }

        // Move both pointers until 'first' reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
            secondIndex++;
        }

        return list.get(secondIndex); // Nth element from the end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        System.out.println("Nth element from end: " + findNthFromEnd(list, n));
    }
}

