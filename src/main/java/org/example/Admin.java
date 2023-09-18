import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Teacher> teachers;
    private List<LessonPlan> lessonPlans;

    public Admin() {
        this.teachers = new ArrayList<>();
        this.lessonPlans = new ArrayList<>();
    }

    // Add new teacher specifying first name, last name, subject
    public boolean addTeacher(String firstName, String lastName, String subject) {
        if (firstName != null && lastName != null && subject != null) {
            Teacher newTeacher = new Teacher(firstName, lastName, subject);
            return teachers.add(newTeacher);
        }
        return false;
    }

    // Remove teacher by first name and last name
    public boolean removeTeacher(String firstName, String lastName) {
        for (Teacher t : teachers) {
            if (t.getFirstName().equals(firstName) && t.getLastName().equals(lastName)) {
                teachers.remove(t);
                return true;
            }
        }
        return false;
    }

    public List<Teacher> viewAllTeachers() {
        return new ArrayList<>(teachers);
    }

    // Add a new lesson plan
    public boolean uploadLessonPlan(String subject, String title, String description) {
        LessonPlan newLessonPlan = new LessonPlan(subject, title, description);
        lessonPlans.add(newLessonPlan);
        return true;
    }

    // View all lesson plans
    public List<LessonPlan> viewAllLessonPlans() {
        return new ArrayList<>(lessonPlans);
    }

    // Remove a lesson plan
    public boolean removeLessonPlan(String subject, String title) {
        for (LessonPlan lp : lessonPlans) {
            if (lp.getSubject().equals(subject) && lp.getTitle().equals(title)) {
                lessonPlans.remove(lp);
                return true;
            }
        }
        return false;
    }
}
