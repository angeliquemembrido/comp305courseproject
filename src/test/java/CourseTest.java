import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void testCourseCreation() {
        Course course = new Course("Math 101", "Introduction to Mathematics");
        assertEquals("Math 101", course.getCourseCode());
        assertEquals("Introduction to Mathematics", course.getDescription());
    }

    @Test
    public void testEnrollStudent() {
        Course course = new Course("Math 101", "Introduction to Mathematics");
        Student student = new Student("John", "Doe");
        assertTrue(course.enrollStudent(student));
        assertTrue(course.getEnrolledStudents().contains(student));
    }

    @Test
    public void testEnrollStudentDuplicate() {
        Course course = new Course("Math 101", "Introduction to Mathematics");
        Student student = new Student("John", "Doe");
        assertTrue(course.enrollStudent(student));
        assertFalse(course.enrollStudent(student)); // Cannot enroll the same student twice
    }
}
