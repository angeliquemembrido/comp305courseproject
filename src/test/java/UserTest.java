import org.example.Teacher;
import org.example.User;
import org.example.LessonPlan;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;


public class UserTest {

    @Test
    public void testConstructorAndGetters() {
        User user = new User("John", "Doe");

        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testViewLessonPlans() {
        User user = new User("John", "Doe");
        List<LessonPlan> lessonPlans = user.viewLessonPlans();
        assertNotNull(lessonPlans);
    }

    @Test
    public void testViewLessonPlans_Empty() {
        User user = new User("John", "Doe");
        assertTrue(user.viewLessonPlans().isEmpty());
    }

    @Test
    public void testAddTeacher() {
        User user = new User("John", "Doe");
        boolean result = user.addTeacher("Jennifer", "Olsen", "Computer Science");
        assertTrue(result);
    }

    @Test
    public void testAddNewTeacher_Empty() {
        User user = new User("John", "Doe");
        boolean result = user.addTeacher("", "", "");
        assertFalse(result);
    }

    @Test
    public void testAddNewTeacher_Null() {
        User user = new User("John", "Doe");
        assertFalse(user.addTeacher(null, "Olsen", "Math"));
        assertFalse(user.addTeacher("Jennifer", null, "Math"));
        assertFalse(user.addTeacher("Jennifer", "Olsen", null));
    }

    @Test
    public void testViewAllTeachers() {
        User user = new User("John", "Doe");
        List<Teacher> teachers = user.viewAllTeachers();
        assertNotNull(teachers);
    }

    @Test
    public void testViewAllTeachers_Empty() {
        User user = new User("John", "Doe");
        assertTrue(user.viewAllTeachers().isEmpty());
    }

    @Test
    public void testAddTeacherAndViewAllTeachers() {
        User user = new User("John", "Doe");
        assertTrue(user.addTeacher("Jennifer", "Olsen", "Math"));
        assertFalse(user.viewAllTeachers().isEmpty());
        assertEquals("Jennifer", user.viewAllTeachers().get(0).getFirstName());
        assertEquals("Olsen", user.viewAllTeachers().get(0).getLastName());
        assertEquals("Math", user.viewAllTeachers().get(0).getSubject());
    }
}

