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

    @Test
    public void testUploadLessonPlan() {
        User user = new User("Angelique", "Membrido");
        String subject = "Computer Science";
        String title = "Object-Oriented Programming";
        String description = "Intro to Test-Driven Development";

        boolean result = user.uploadLessonPlan(subject, title, description);

        assertTrue(result);
    }

    @Test
    public void testInvalidUploadParameters_NullSubject() {
        User user = new User("Angelique", "Membrido");
        boolean result = user.uploadLessonPlan(null, "Object-Oriented Programming", "Intro to Test-Driven Development");
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_EmptySubject() {
        User user = new User("Angelique", "Membrido");
        boolean result = user.uploadLessonPlan("", "Object-Oriented Programming", "Intro to Test-Driven Development");
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_NullTitle() {
        User user = new User("Angelique", "Membrido");
        boolean result = user.uploadLessonPlan("Computer", null, "Intro to Test-Driven Development");
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_EmptyTitle() {
        User user = new User("Angelique", "Membrido");
        boolean result = user.uploadLessonPlan("Computer", "", "Intro to Test-Driven Development");
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_NullDescription() {
        User user = new User("Angelique", "Membrido");
        boolean result = user.uploadLessonPlan("Computer", "Object-Oriented Programming", null);
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_EmptyDescription() {
        User user = new User("Angelique", "Membrido");
        boolean result = user.uploadLessonPlan("Computer", "Object-Oriented Programming", "");
        assertFalse(result);
    }

    @Test
    public void testSearchBySubject() {

        User user = new User("Angelique", "Membrido");
        user.uploadLessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");

        List<LessonPlan> results = user.searchBySubject("Computer Science");
        assertNotNull(results);
        assertFalse(results.isEmpty());
    }

    @Test
    public void testSearchByNonExistentSubject() {

        User user = new User("Angelique", "Membrido");
        user.uploadLessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");

        List<LessonPlan> results = user.searchBySubject("Art");
        assertTrue(results.isEmpty());
    }
    @Test
    public void testSearchByEmptySubject() {

        User user = new User("Angelique", "Membrido");
        user.uploadLessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");

        List<LessonPlan> results = user.searchBySubject("");
        assertTrue(results.isEmpty());
    }
    @Test
    public void testSearchByNullSubject() {

        User user = new User("Angelique", "Membrido");
        user.uploadLessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");

        List<LessonPlan> results = user.searchBySubject(null);
        assertTrue(results.isEmpty());
    }







}

