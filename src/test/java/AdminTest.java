import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

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

        // Add teachers
        admin.addTeacher("John", "Doe", "Math");
        admin.addTeacher("Jane", "Doe", "English");

        List<Teacher> teachers = admin.viewAllTeachers();

        boolean teacher1Found = false;
        boolean teacher2Found = false;

        for (Teacher teacher : teachers) {
            if (teacher.getFirstName().equals("John") && teacher.getLastName().equals("Doe") && teacher.getSubject().equals("Math")) {
                teacher1Found = true;
            }
            if (teacher.getFirstName().equals("Jane") && teacher.getLastName().equals("Doe") && teacher.getSubject().equals("English")) {
                teacher2Found = true;
            }
        }
        assertTrue(teacher1Found);
        assertTrue(teacher2Found);
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
        LessonPlan lp1 = new LessonPlan("Math", "Algebra", "Introduction to Algebra");
        LessonPlan lp2 = new LessonPlan("Science", "Physics", "Newton's Laws");

        admin.uploadLessonPlan(lp1.getSubject(), lp1.getTitle(), lp1.getDescription());
        admin.uploadLessonPlan(lp2.getSubject(), lp2.getTitle(), lp2.getDescription());

        List<LessonPlan> lessonPlans = admin.viewAllLessonPlans();

        assertNotNull(lessonPlans);
        assertTrue(lessonPlans.contains(lp1) && lessonPlans.contains(lp2));
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

