package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code User} class represents a user with first name, last name, and the ability to interact with lesson plans and teachers.
 * Users can view lesson plans, manage teachers, upload lesson plans, and search for lesson plans by subject.
 */
public class User {
    private final String firstName;  // The first name of the user.
    private final String lastName;   // The last name of the user.
    protected List<LessonPlan> lessonPlans;  // The list of lesson plans associated with the user.
    protected List<Teacher> teachers;        // The list of teachers associated with the user.

    /**
     * Constructs a new user with the specified first name and last name.
     *
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lessonPlans = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Views all lesson plans associated with the user.
     *
     * @return A list of lesson plans.
     */
    public List<LessonPlan> viewLessonPlans() {
        return LessonPlan.lessonPlans;
    }

    /**
     * Gets the list of teachers associated with the user.
     *
     * @return A list of teachers.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Adds a new teacher with the specified first name, last name, and subject.
     *
     * @param firstName The first name of the teacher.
     * @param lastName  The last name of the teacher.
     * @param subject   The subject the teacher teaches.
     * @return true if the teacher is added successfully, false otherwise.
     */
    public boolean addTeacher(String firstName, String lastName, String subject) {
        if (firstName != null && !firstName.isEmpty() &&
                lastName != null && !lastName.isEmpty() &&
                subject != null && !subject.isEmpty()) {
            Teacher newTeacher = new Teacher(firstName, lastName, subject);
            return teachers.add(newTeacher);
        }
        return false;
    }

    /**
     * Views all teachers associated with the user.
     *
     * @return A list of teachers.
     */
    public List<Teacher> viewAllTeachers() {
        return new ArrayList<>(teachers);
    }

    /**
     * Uploads a new lesson plan with the specified subject, title, and description.
     *
     * @param subject     The subject of the lesson plan.
     * @param title       The title of the lesson plan.
     * @param description The description of the lesson plan.
     * @return true if the lesson plan is uploaded successfully, false otherwise.
     */
    public boolean uploadLessonPlan(String subject, String title, String description) {
        if (subject == null || subject.isEmpty() ||
                title == null || title.isEmpty() ||
                description == null || description.isEmpty()) {
            return false;
        }

        LessonPlan newLessonPlan = new LessonPlan(subject, title, description);
        return LessonPlan.lessonPlans.add(newLessonPlan);
    }

    /**
     * Searches for lesson plans by subject.
     *
     * @param subject The subject to search for.
     * @return A list of lesson plans with matching subjects.
     */
    public List<LessonPlan> searchBySubject(String subject) {
        if (subject == null || subject.isEmpty()) {
            return new ArrayList<>(); // return an empty list
        }

        return LessonPlan.lessonPlans.stream()
                .filter(lp -> subject.equals(lp.getSubject()))
                .collect(Collectors.toList());
    }
}

