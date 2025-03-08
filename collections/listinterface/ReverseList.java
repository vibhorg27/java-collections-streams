package com.bridgelabz.collections.listinterface;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseList {

    public static List<Integer> reverseArrayList(List<Integer> arrayList){
        int n = arrayList.size();
//        System.out.println(n);
        List<Integer> ans = new ArrayList<>();

        for(int i = n-1 ; i>=0; i--){
            ans.add(arrayList.get(i));
        }

        return ans;
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }

        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        List<Integer> result = reverseArrayList(list);
        System.out.println(result);

        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1,2,3, 4, 5));
        linkedList = reverseLinkedList(linkedList);
        System.out.println(linkedList);
    }
}
