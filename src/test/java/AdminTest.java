import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class AdminTest {



    @Test
    public void testRemoveTeacher() {
        Admin admin = new Admin("Angelique", "Membrido");
        boolean added = admin.addTeacher("Jennifer", "Olsen", "Computer Science");
        boolean removed = admin.removeTeacher("Jennifer", "Olsen");
        assertTrue(added);
        assertTrue(removed);
    }

    @Test
    public void testRemoveTeacher_NonExistent() {
        Admin admin = new Admin("Angelique", "Membrido");
        boolean result = admin.removeTeacher("Jane", "Doe");
        assertFalse(result, "Removing a non-existent teacher should return false");
    }


    @Test
    public void testRemoveLessonPlan() {
        Admin admin = new Admin("Angelique", "Membrido");
        admin.uploadLessonPlan("Computer Science", "Object-Oriented Programming", "An introduction to OOP");
        boolean result = admin.removeLessonPlan("Computer Science", "Object-Oriented Programming");
        assertTrue(result);
    }

    @Test
    public void testRemoveLessonPlan_NonExistent() {
        Admin admin = new Admin("Angelique", "Membrido");
        boolean result = admin.removeLessonPlan("Art", "History of Art");
        assertFalse(result, "Removing a non-existent lesson plan should return false");
    }

    @Test
    public void testAddTeacher_InvalidDetails() {
        Admin admin = new Admin("Angelique", "Membrido");
        assertFalse(admin.addTeacher("", "Olsen", "Computer Science"));
        assertFalse(admin.addTeacher("Jennifer", "", "Computer Science"));
        assertFalse(admin.addTeacher("Jennifer", "Olsen", ""));
    }

    @Test
    public void testRemoveTeacher_Twice() {
        Admin admin = new Admin("Angelique", "Membrido");
        admin.addTeacher("Jennifer", "Olsen", "Computer Science");
        assertTrue(admin.removeTeacher("Jennifer", "Olsen"));
        assertFalse(admin.removeTeacher("Jennifer", "Olsen"));
    }

    @Test
    public void testRemoveLessonPlan_Twice() {
        Admin admin = new Admin("Angelique", "Membrido");
        admin.uploadLessonPlan("Computer Science", "OOP", "Intro to OOP");
        assertTrue(admin.removeLessonPlan("Computer Science", "OOP"));
        assertFalse(admin.removeLessonPlan("Computer Science", "OOP"));
    }

}

