package com.bridgelabz.collections.queueinterface;

import java.util.*;

class StackByQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.offer(x);

    }

    public int pop() {
        if (q1.isEmpty()) return -1;
        while (q1.size() > 1) {

            q2.offer(q1.poll());
        }

        int popped = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public int peek() {
        if (q1.isEmpty()) return -1;

        return ((LinkedList<Integer>) q1).getLast();
    }

    public boolean isEmpty() {
        return q1.isEmpty();

    }
}

public class StackUsingQueue{
    public static void main(String[] args) {
        StackByQueue stack = new StackByQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}

