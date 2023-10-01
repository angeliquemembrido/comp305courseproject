package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * The `Course` class represents a course offered in the system.
 */
public class Course {
    // Course code (e.g., COMP305)
    private String courseCode;

    // Description of the course
    private String description;

    // List of students enrolled in the course
    private List<Student> enrolledStudents;

    // A list to store all available courses (static to share across instances)
    public static List<Course> allCourses = new ArrayList<>();

    /**
     * Creates a new `Course` object with the specified course code and description.
     *
     * @param courseCode  The unique course code.
     * @param description A brief description of the course.
     */
    public Course(String courseCode, String description) {
        this.courseCode = courseCode;
        this.description = description;
        this.enrolledStudents = new ArrayList<>();
    }

    /**
     * Gets the course code.
     *
     * @return The course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Gets the description of the course.
     *
     * @return The course description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets a list of students enrolled in the course.
     *
     * @return A list of enrolled students.
     */
    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents);
    }

    /**
     * Gets a list of all available courses.
     *
     * @return A list of all courses.
     */
    public static List<Course> getAllCourses() {
        return new ArrayList<>(allCourses);
    }

    /**
     * Enrolls a student in the course.
     *
     * @param student The student to enroll.
     * @return `true` if the student is successfully enrolled, `false` if already enrolled.
     */
    public boolean enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            // Student is not already enrolled, so add student
            return enrolledStudents.add(student);
        }
        // Student is already enrolled, return false to indicate that enrollment failed
        return false;
    }
}

