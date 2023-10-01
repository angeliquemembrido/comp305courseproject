package org.example;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String description;
    private List<Student> enrolledStudents;


    public Course(String courseCode, String description) {
        this.courseCode = courseCode;
        this.description = description;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getDescription() {
        return description;
    }

    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents);
    }


    public boolean enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            // Student is not already enrolled, so add student
            return enrolledStudents.add(student);
        }
        // Student is already enrolled, return false to indicate that enrollment failed
        return false;
    }
}
