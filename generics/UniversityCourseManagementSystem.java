package com.bridgelabz.generics;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType{
    private String courseName;
    private String instructorName;

    public CourseType(String courseName ,String instructorName){
        this.courseName = courseName;
        this.instructorName = instructorName;
    }

    //getter
    public String getInstructorName() {
        return instructorName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + courseName + " (Instructor: " + instructorName + ")";
    }
}

class ExamCourse extends CourseType{
    public ExamCourse(String courseName ,String instructorName){
        super(courseName, instructorName);
    }
}

class AssignmentCourse extends CourseType{
    public AssignmentCourse(String courseName ,String instructorName){
        super(courseName, instructorName);
    }
}

class ResearchCourse extends AssignmentCourse{
    public ResearchCourse(String courseName ,String instructorName){
        super(courseName, instructorName);
    }
}

class Course<T extends CourseType>{
    List<T> courseList = new ArrayList<>();

    public void addCourse(T course){
        courseList.add(course);
    }
    public List<T> getCourseList(){
        return courseList;
    }
}
class University {
    private List<Course<? extends CourseType>> allCourses = new ArrayList<>();

    public void addDepartmentCourse(Course<? extends CourseType> course) {
        allCourses.add(course);
    }

    public void displayAllCourses() {
        for (Course<? extends CourseType> departmentCourses : allCourses) {
            for (CourseType course : departmentCourses.getCourseList()) {
                System.out.println(course);
            }
        }
    }
}

public class UniversityCourseManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        examCourses.addCourse(new ExamCourse("Mathematics", "Dr. Smith"));
        examCourses.addCourse(new ExamCourse("Physics", "Dr. Johnson"));

        assignmentCourses.addCourse(new AssignmentCourse("Computer Science", "Prof. Adams"));
        assignmentCourses.addCourse(new AssignmentCourse("Business Studies", "Prof. Baker"));

        researchCourses.addCourse(new ResearchCourse("Artificial Intelligence", "Dr. White"));
        researchCourses.addCourse(new ResearchCourse("Quantum Computing", "Dr. Black"));

        University university = new University();
        university.addDepartmentCourse(examCourses);
        university.addDepartmentCourse(assignmentCourses);
        university.addDepartmentCourse(researchCourses);

        System.out.println("All Courses in University:");
        university.displayAllCourses();
    }
}

