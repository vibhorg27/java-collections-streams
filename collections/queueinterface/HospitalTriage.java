package com.bridgelabz.collections.queueinterface;

import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;

    }
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);

    }

    @Override
    public String toString() {


        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {

        PriorityQueue<Patient> queue = new PriorityQueue<>();

        queue.offer(new Patient("Vibhor", 3));
        queue.offer(new Patient("Mayank", 5));
        queue.offer(new Patient("Sreyas", 2));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

