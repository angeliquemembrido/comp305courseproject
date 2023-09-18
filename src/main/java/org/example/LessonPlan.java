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

}

