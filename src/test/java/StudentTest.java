import static org.junit.jupiter.api.Assertions.*;

import org.example.Student;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void testConstructorAndGetters() {
        Student student = new Student("Angelique", "Membrido");

        assertEquals("Angelique", student.getFirstName());
        assertEquals("Membrido", student.getLastName());
    }


}
