import java.util.ArrayList;
import java.util.List;

public class LessonPlan {
    private String subject;
    private String title;
    private String description;

    // Static list to hold all lesson plans.
    private static List<LessonPlan> lessonPlans = new ArrayList<>();

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

    // Uploads a new lesson plan to the static list.
    public static boolean uploadLessonPlan(LessonPlan plan) {
        if (plan == null || plan.subject == null || plan.title == null || plan.description == null ||
                plan.subject.isEmpty() || plan.title.isEmpty() || plan.description.isEmpty()) {
            return false;
        }

        // Check for duplicates
        for (LessonPlan existingPlan : lessonPlans) {
            if (existingPlan.getSubject().equals(plan.getSubject()) && existingPlan.getTitle().equals(plan.getTitle()) && existingPlan.getDescription().equals(plan.getDescription())) {
                return false; // Duplicate found
            }
        }

        lessonPlans.add(plan);
        return true;
    }

    // Deletes a lesson plan based on subject, title.
    public static boolean deleteLessonPlan(String subject, String title) {
        return lessonPlans.removeIf(plan -> plan.getSubject().equals(subject) && plan.getTitle().equals(title));
    }

    // Searches for lesson plans by subject.
    public static List<LessonPlan> searchBySubject(String subject) {
        List<LessonPlan> foundPlans = new ArrayList<>();
        for (LessonPlan plan : lessonPlans) {
            if (plan.getSubject().equals(subject)) {
                foundPlans.add(plan);
            }
        }
        return foundPlans;
    }
}

