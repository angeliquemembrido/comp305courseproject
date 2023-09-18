import org.example.LessonPlan;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LessonPlanTest {




    @Test
    public void testSearchByNonExistentSubject() {
        List<LessonPlan> results = LessonPlan.searchBySubject("Art");
        assertTrue(results.isEmpty());
    }



}

