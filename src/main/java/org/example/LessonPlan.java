package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * The LessonPlan class represents a lesson plan with subject, title, and description.
 */
public class LessonPlan {
    private final String subject;      // The subject of the lesson plan.
    private final String title;        // The title of the lesson plan.
    private final String description;  // The description of the lesson plan.

    // Static list to hold all lesson plans.
    protected static List<LessonPlan> lessonPlans = new ArrayList<>();

    /**
     * Constructs a new lesson plan with the specified subject, title, and description.
     *
     * @param subject     The subject of the lesson plan.
     * @param title       The title of the lesson plan.
     * @param description The description of the lesson plan.
     */
    public LessonPlan(String subject, String title, String description) {
        this.subject = subject;
        this.title = title;
        this.description = description;
    }

    /**
     * Gets the subject of the lesson plan.
     *
     * @return The subject of the lesson plan.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Gets the title of the lesson plan.
     *
     * @return The title of the lesson plan.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the description of the lesson plan.
     *
     * @return The description of the lesson plan.
     */
    public String getDescription() {
        return description;
    }
}
