import org.example.LessonPlan;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LessonPlanTest {

    @Test
    public void testConstructor() {
        LessonPlan newLessonPlan = new LessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");
        assertEquals("Computer Science", newLessonPlan.getSubject());
        assertEquals("Object-Oriented Programming", newLessonPlan.getTitle());
        assertEquals("Intro to Test-Driven Development", newLessonPlan.getDescription());
    }

    @Test
    public void testGetSubject() {
        LessonPlan newLessonPlan = new LessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");
        assertEquals("Computer Science", newLessonPlan.getSubject());
    }

    @Test
    public void testGetTitle() {
        LessonPlan newLessonPlan = new LessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");
        assertEquals("Object-Oriented Programming", newLessonPlan.getTitle());
    }

    @Test
    public void testGetDescription() {
        LessonPlan newLessonPlan = new LessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");
        assertEquals("Intro to Test-Driven Development", newLessonPlan.getDescription());
    }

}

