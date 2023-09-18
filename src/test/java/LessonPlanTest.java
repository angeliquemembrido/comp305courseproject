import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LessonPlanTest {

    @Test
    public void testUploadLessonPlan() {
        LessonPlan plan = new LessonPlan("Computer Science", "Object-Oriented Programming", "Intro to Test-Driven Development");
        boolean result = LessonPlan.uploadLessonPlan(plan);
        assertTrue(result);
    }
    @Test
    public void testInvalidUploadParameters_NullSubject() {
        LessonPlan plan = new LessonPlan(null, "Object-Oriented Programming", "Intro to Test-Driven Development");
        boolean result = LessonPlan.uploadLessonPlan(plan);
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_EmptySubject() {
        LessonPlan plan = new LessonPlan("", "Object-Oriented Programming", "Intro to Test-Driven Development");
        boolean result = LessonPlan.uploadLessonPlan(plan);
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_NullTitle() {
        LessonPlan plan = new LessonPlan("Computer Science", null, "Intro to Test-Driven Development");
        boolean result = LessonPlan.uploadLessonPlan(plan);
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_EmptyTitle() {
        LessonPlan plan = new LessonPlan("Computer Science", "", "Intro to Test-Driven Development");
        boolean result = LessonPlan.uploadLessonPlan(plan);
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_NullDescription() {
        LessonPlan plan = new LessonPlan("Computer Science", "Object-Oriented Programming", null);
        boolean result = LessonPlan.uploadLessonPlan(plan);
        assertFalse(result);
    }

    @Test
    public void testInvalidUploadParameters_EmptyDescription() {
        LessonPlan plan = new LessonPlan("Computer Science", "Object-Oriented Programming", "");
        boolean result = LessonPlan.uploadLessonPlan(plan);
        assertFalse(result);
    }

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
