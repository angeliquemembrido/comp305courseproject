import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

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
    public void testAddTeacher() {
        User user = new User("John", "Doe");
        boolean result = user.addTeacher("Jennifer", "Olsen", "Computer Science");
        assertTrue(result);
    }

    public void testAddNewTeacher_Empty() {
        User user = new User("John", "Doe");
        boolean result = user.addTeacher("", "", "");
        assertFalse(result);
    }

    public void testAddNewTeacher_Null() {
        User user = new User("John", "Doe");
        boolean result = user.addTeacher(null, null, null);
        assertFalse(result);
    }

    @Test
    public void testViewAllTeachers() {
        User user = new User("John", "Doe");
        List<Teacher> teachers = user.viewAllTeachers();
        assertNotNull(teachers);
    }
}

