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
        Teacher teacher = new Teacher("John", "Doe", "Math");
        teacher.setSubject("Science");
        assertEquals("Science", teacher.getSubject());
    }






}
