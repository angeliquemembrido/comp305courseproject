import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean upload(String subject, String title, String description) {
        if (subject == null || subject.isEmpty() || title == null || title.isEmpty() || description == null || description.isEmpty()) {
            return false;
        }

        // Check for duplicates
        for (LessonPlan existingPlan : lessonPlans) {
            if (existingPlan.getSubject().equals(subject) && existingPlan.getTitle().equals(title) && existingPlan.getDescription().equals(description)) {
                return false; // Duplicate found
            }
        }

        this.subject = subject;
        this.title = title;
        this.description = description;
        lessonPlans.add(this);
        return true;
    }

    // Uploads a new lesson plan to the static list.
    public static boolean uploadLessonPlan(LessonPlan plan) {
        if (plan == null || plan.getSubject() == null || plan.getTitle() == null || plan.getDescription() == null) {
            return false;
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

