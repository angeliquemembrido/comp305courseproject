import org.example.Teacher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void testTeacherConstructor() {
        Teacher teacher = new Teacher("Jennifer", "Olsen", "Computer Science");
        assertEquals("Jennifer", teacher.getFirstName());
        assertEquals("Olsen", teacher.getLastName());
        assertEquals("Computer Science", teacher.getSubject());
    }
    @Test
    public void testSetSubject() {
        Teacher teacher = new Teacher("Jennifer", "Olsen", "Computer Science");
        teacher.setSubject("Science");
        assertEquals("Science", teacher.getSubject());
    }

    @Test
    public void testInvalidSubject() {
        Teacher teacher = new Teacher("Jennifer", "Olsen", "Computer Science");
        assertThrows(IllegalArgumentException.class, () -> teacher.setSubject(""));
        assertThrows(IllegalArgumentException.class, () -> teacher.setSubject(null));
    }

}
