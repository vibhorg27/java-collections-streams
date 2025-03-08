package com.bridgelabz.collections.queueinterface;

class CircularBuffer {
    private int[] buffer;
    private int size, front, rear;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];

        size = 0;
        front = 0;

        rear = -1;
    }

    public void insert(int x) {
        rear = (rear + 1) % buffer.length;

        buffer[rear] = x;
        if (size < buffer.length) {

            size++;
        } else {
            front = (front + 1) % buffer.length; // Overwrite oldest
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {

            System.out.print(buffer[(front + i) % buffer.length] + " ");
        }
        System.out.println();
    }
}

public class CircularBufferSimulation {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);

        buffer.insert(3);
        buffer.display();

        buffer.insert(4);
        buffer.display();
    }
}

