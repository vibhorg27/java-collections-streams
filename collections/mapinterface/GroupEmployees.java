package com.bridgelabz.collections.mapinterface;

import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupEmployees {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        }

        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Vibh", "HR"),
                new Employee("May", "IT"),
                new Employee("leom", "HR")
        );

        System.out.println(groupByDepartment(employees));
    }
}

