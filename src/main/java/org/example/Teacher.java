import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private String subject;

    // Static list to hold all teachers.
    private static List<Teacher> teachers = new ArrayList<>();

    public Teacher(String firstName, String lastName, String subject) {
        super(firstName, lastName);
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public static boolean addNewTeacher(Teacher teacher) {
        if (teacher == null || teacher.getFirstName() == null || teacher.getLastName() == null || teacher.getSubject() == null) {
            return false;
        }
        if (teacher.getFirstName().isEmpty() || teacher.getLastName().isEmpty() || teacher.getSubject().isEmpty()) {
            return false;
        }
        return teachers.add(teacher);
    }

    public static boolean removeTeacher(String firstName, String lastName) {
        return teachers.removeIf(teacher -> teacher.getFirstName().equals(firstName) && teacher.getLastName().equals(lastName));
    }
}

