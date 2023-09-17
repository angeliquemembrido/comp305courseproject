import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AdminTest {

    @Test
    public void testAddTeacher() {
        Admin admin = new Admin();
        boolean result = admin.addTeacher("Jennifer", "Olsen", "Computer Science");
        assertTrue(result);
    }

    @Test
    public void testRemoveTeacher() {
        Admin admin = new Admin();
        boolean added = admin.addTeacher("Jennifer", "Olsen", "Computer Science");
        boolean removed = admin.removeTeacher("Jennifer", "Olsen");
        assertTrue(added);
        assertTrue(removed);
    }

    @Test
    public void testRemoveTeacher_NonExistent() {
        Admin admin = new Admin();
        boolean result = admin.removeTeacher("Jane", "Doe");
        assertFalse(result, "Removing a non-existent teacher should return false");
    }

    @Test
    public void testViewAllTeachers() {
        Admin admin = new Admin();
        Teacher teacher1 = new Teacher("John", "Doe");
        Teacher teacher2 = new Teacher("Jane", "Doe");
        admin.addTeacher(teacher1);
        admin.addTeacher(teacher2);
        List<Teacher> teachers = admin.viewAllTeachers();
        assertTrue(teachers.contains(teacher1) && teachers.contains(teacher2));
    }

    @Test
    public void testUploadLessonPlan() {
        Admin admin = new Admin();
        boolean result = admin.uploadLessonPlan("Math", "Algebra Basics", "Introduction to Algebra");
        assertTrue(result);
    }

    @Test
    public void testViewAllLessonPlans() {
        Admin admin = new Admin();
        assertNotNull(admin.viewAllLessonPlans());
    }

    @Test
    public void testRemoveLessonPlan() {
        Admin admin = new Admin();
        admin.uploadLessonPlan("Computer Science", "Object-Oriented Programming", "An introduction to OOP");
        boolean result = admin.removeLessonPlan("Computer Science", "Object-Oriented Programming");
        assertTrue(result);
    }

    @Test
    public void testRemoveLessonPlan_NonExistent() {
        Admin admin = new Admin();
        boolean result = admin.removeLessonPlan("Art", "History of Art");
        assertFalse(result, "Removing a non-existent lesson plan should return false");
    }


}

