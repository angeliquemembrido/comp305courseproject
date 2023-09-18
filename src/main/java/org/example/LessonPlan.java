package org.example;
import java.util.ArrayList;
import java.util.List;

public class LessonPlan {
    private final String subject;
    private final String title;
    private final String description;

    // Static list to hold all lesson plans.
    private final static List<LessonPlan> lessonPlans = new ArrayList<>();

    public LessonPlan(String subject, String title, String description) {
        this.subject = subject;
        this.title = title;
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    // Deletes a lesson plan based on subject, title.
    public static boolean deleteLessonPlan(String subject, String title) {
        return lessonPlans.removeIf(plan -> plan.getSubject().equals(subject) && plan.getTitle().equals(title));}

    // Searches for lesson plans by subject.
    public static List<LessonPlan> searchBySubject(String subject) {
        List<LessonPlan> foundPlans = new ArrayList<>();
        for (LessonPlan plan : lessonPlans) {
            if (plan.getSubject().equals(subject)) {
                foundPlans.add(plan);}
        }
        return foundPlans;}
}

