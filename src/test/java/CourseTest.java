import static org.junit.jupiter.api.Assertions.*;

import org.example.Course;
import org.example.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CourseTest {

    @Test
    public void testGetDescription() {
        Course course = new Course("COMP 305", "Object-Oriented Programming");
        String description = course.getDescription();
        assertEquals("Object-Oriented Programming", description);
    }
    @Test
    public void testCourseCreation() {
        Course course = new Course("COMP 305", "Object-Oriented Programming");
        assertEquals("COMP 305", course.getCourseCode());
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

    @Test
    void testGetAllCourses() {
        Course course = new Course("COMP305", "Object-Oriented Programming");
        Course.allCourses.add(course);
        List<Course> allCourses = Course.getAllCourses();
        assertTrue(((List<?>) allCourses).contains(course));
        assertNotSame(Course.allCourses, allCourses);
    }

    @Test
    void testGetCourseCode() {
        Course course = new Course("COMP305", "Object-Oriented Programming");
        String courseCode = course.getCourseCode();
        assertEquals("COMP305", courseCode);
    }
}
