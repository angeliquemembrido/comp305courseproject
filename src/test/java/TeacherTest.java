import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void testAddNewTeacher() {
        Teacher newTeacher = new Teacher("Jennifer", "Olsen", "Computer Science");
        boolean result = Teacher.addNewTeacher(newTeacher);
        assertTrue(result);
    }

    @Test
    public void testAddNewTeacher_Empty() {
        Teacher newTeacher = new Teacher("", "", "");
        boolean result = Teacher.addNewTeacher(newTeacher);
        assertFalse(result);
    }

    @Test
    public void testAddNewTeacher_Null() {
        Teacher newTeacher = new Teacher(null, null, null);
        boolean result = Teacher.addNewTeacher(newTeacher);
        assertFalse(result);
    }

    @Test
    public void testRemoveTeacher() {
        Teacher newTeacher = new Teacher("Jennifer", "Olsen", "Computer Science");
        Teacher.addNewTeacher(newTeacher);
        boolean result = Teacher.removeTeacher("Jennifer", "Olsen");
        assertTrue(result);
    }
}
