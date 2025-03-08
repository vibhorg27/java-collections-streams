package com.bridgelabz.collections.setinterface;

import java.util.*;

public class ConvertSetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        return new ArrayList<>(new TreeSet<>(set));
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        System.out.println("Sorted List: " + convertToSortedList(set));
    }

}
