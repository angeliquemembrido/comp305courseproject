package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final String firstName;
    private final String lastName;
    protected List<LessonPlan> lessonPlans;
    protected List<Teacher> teachers;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lessonPlans = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public List<LessonPlan> viewLessonPlans() {
        return LessonPlan.lessonPlans;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }


    public boolean addTeacher(String firstName, String lastName, String subject) {
        if (firstName != null && !firstName.isEmpty() &&
                lastName != null && !lastName.isEmpty() &&
                subject != null && !subject.isEmpty()) {
            Teacher newTeacher = new Teacher(firstName, lastName, subject);
            return teachers.add(newTeacher);
        }
        return false;
    }

    public List<Teacher> viewAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public boolean uploadLessonPlan(String subject, String title, String description) {
        if (subject == null || subject.isEmpty() ||
                title == null || title.isEmpty() ||
                description == null || description.isEmpty()) {
            return false;
        }

        LessonPlan newLessonPlan = new LessonPlan(subject, title, description);
        return LessonPlan.lessonPlans.add(newLessonPlan);
    }

    public List<LessonPlan> searchBySubject(String subject) {
        if (subject == null || subject.isEmpty()) {
            return new ArrayList<>(); // return an empty list
        }

        return LessonPlan.lessonPlans.stream()
                .filter(lp -> subject.equals(lp.getSubject()))
                .collect(Collectors.toList());
    }




}

