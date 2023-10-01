import static org.junit.jupiter.api.Assertions.*;

import org.example.Course;
import org.example.Student;
import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void testCourseCreation() {
        Course course = new Course("COMP 305", "Object-Oriented Programming");
        assertEquals("Math 101", course.getCourseCode());
        assertEquals("Object-Oriented Programming", course.getDescription());
    }

    @Test
    public void testEnrollStudent() {
        Course course = new Course("COMP 305", "Object-Oriented Programming");
        Student student = new Student("Angelique", "Membrido");
        assertTrue(course.enrollStudent(student));
        assertTrue(course.getEnrolledStudents().contains(student));
    }

    @Test
    public void testEnrollStudentDuplicate() {
        Course course = new Course("COMP 305", "Object-Oriented Programming");
        Student student = new Student("Angelique", "Membrido");
        assertTrue(course.enrollStudent(student));
        assertFalse(course.enrollStudent(student)); // Cannot enroll the same student twice
    }
}
