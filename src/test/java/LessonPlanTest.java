import org.example.LessonPlan;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LessonPlanTest {


    @Test
    public void testSearchBySubject() {
        LessonPlan plan = new LessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");
        LessonPlan.uploadLessonPlan(plan);
        List<LessonPlan> results = LessonPlan.searchBySubject("Computer Science");
        assertNotNull(results);
        assertFalse(results.isEmpty());
    }

    @Test
    public void testSearchByNonExistentSubject() {
        List<LessonPlan> results = LessonPlan.searchBySubject("Art");
        assertTrue(results.isEmpty());
    }

    @Test
    public void testDeleteLessonPlan() {
        LessonPlan plan = new LessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");
        LessonPlan.uploadLessonPlan(plan);
        boolean result = LessonPlan.deleteLessonPlan("Computer Science", "Object-Oriented Programming");
        assertTrue(result);
    }

}

