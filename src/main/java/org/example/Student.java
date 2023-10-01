package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Student} class represents a student with first name, last name, and a list of enrolled courses.
 */
public class Student {
    private String firstName;               // The first name of the student.
    private String lastName;                // The last name of the student.
    private List<Course> enrolledCourses;   // The list of courses in which the student is enrolled.

    /**
     * Constructs a new student with the specified first name and last name.
     *
     * @param firstName The first name of the student.
     * @param lastName  The last name of the student.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrolledCourses = new ArrayList<>(); // Initialize the enrolledCourses list
    }

    /**
     * Gets the first name of the student.
     *
     * @return The first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return The last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets a list of enrolled courses by the student.
     *
     * @return A list of enrolled courses.
     */
    public List<Course> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }

    /**
     * Enrolls the student in a course.
     *
     * @param course The course to enroll in.
     * @return true if enrollment is successful, false if the student is already enrolled in the course.
     */
    public boolean enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            return true; // Enrollment successful
        }
        return false; // Student is already enrolled in the course
    }
}
