package com.bridgelabz.collections.listinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateInList {
    public static List<Integer> rotateList(List<Integer> input, int k){
        int n = input.size();
        k = k % n;

        List<Integer> rotatedList = new ArrayList<>();

        rotatedList.addAll(input.subList(k,n));
        rotatedList.addAll(input.subList(0,k));


        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int k = 2;

        List<Integer> result = rotateList(list, k);
        System.out.println(result);
    }
}
