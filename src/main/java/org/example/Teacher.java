import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String firstName;
    private String lastName;
    private String subject;

    private static List<Teacher> teachers = new ArrayList<>();

    public Teacher(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }


    public static boolean AddNewTeacher(Teacher teacher) {
        if (teacher == null || teacher.firstName == null || teacher.lastName == null || teacher.subject == null) {
            return false;
        }
        if (teacher.firstName.isEmpty() || teacher.lastName.isEmpty() || teacher.subject.isEmpty()) {
            return false;
        }
        return teachers.add(teacher);
    }
}



