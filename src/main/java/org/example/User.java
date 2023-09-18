import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    protected List<LessonPlan> lessonPlans;
    private List<Teacher> teachers;

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
        return new ArrayList<>(lessonPlans);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }


    public boolean addTeacher(String firstName, String lastName, String subject) {
        if (firstName != null && lastName != null && subject != null) {
            Teacher newTeacher = new Teacher(firstName, lastName, subject);
            return teachers.add(newTeacher);
        }
        return false;
    }

    public List<Teacher> viewAllTeachers() {
        return new ArrayList<>(teachers);
    }

}

