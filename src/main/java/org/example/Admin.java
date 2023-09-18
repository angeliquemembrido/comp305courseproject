import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<Teacher> teachers;
    private List<LessonPlan> lessonPlans;

    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
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
        Teacher teacherToRemove = null;
        for (Teacher t : teachers) {
            if (t.getFirstName().equals(firstName) && t.getLastName().equals(lastName)) {
                teacherToRemove = t;
                break;
            }
        }
        if (teacherToRemove != null) {
            teachers.remove(teacherToRemove);
            return true;
        }
        return false;
    }

    public List<Teacher> viewAllTeachers() {
        return new ArrayList<>(teachers);
    }

    // Admin-specific method to remove a lesson plan
    public boolean removeLessonPlan(String subject, String title) {
        LessonPlan lessonPlanToRemove = null;
        for (LessonPlan lp : lessonPlans) {
            if (lp.getSubject().equals(subject) && lp.getTitle().equals(title)) {
                lessonPlanToRemove = lp;
                break;
            }
        }
        if (lessonPlanToRemove != null) {
            lessonPlans.remove(lessonPlanToRemove);
            return true;
        }
        return false;
    }
}


