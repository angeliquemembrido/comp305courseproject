package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Course> enrolledCourses;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrolledCourses = new ArrayList<>(); // Initialize the enrolledCourses list
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Course> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }

    public boolean enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            return true; // Enrollment successful
        }
        return false; // Student is already enrolled in the course
    }

}
