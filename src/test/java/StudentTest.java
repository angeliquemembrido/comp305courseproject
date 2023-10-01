import static org.junit.jupiter.api.Assertions.*;

import org.example.Course;
import org.example.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentTest {

    @Test
    public void testConstructorAndGetters() {
        Student student = new Student("Angelique", "Membrido");

        assertEquals("Angelique", student.getFirstName());
        assertEquals("Membrido", student.getLastName());
    }

    @Test
    public void testGetEnrolledCourses() {
        Student student = new Student("John", "Doe");

        Course course1 = new Course("CS101", "Introduction to Computer Science");
        Course course2 = new Course("MATH101", "Calculus 101");

        student.enrollCourse(course1);
        student.enrollCourse(course2);

        List<Course> enrolledCourses = student.getEnrolledCourses();

        assertTrue(enrolledCourses.contains(course1));
        assertTrue(enrolledCourses.contains(course2));

    }


}
