import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradebookTester {
   private GradeBook g1;
   private GradeBook g2;

   @Before
   public void setUp() {
      g1 = new GradeBook(5);
      g2 = new GradeBook(5);

      g1.addScore(50);
      g1.addScore(75);

      g2.addScore(85);
      g2.addScore(95);
   }

   @After
   public void tearDown() {
      g1 = null;
      g2 = null;
   }

   // Test addScore method
   @Test
   public void testAddScore() {
      assertTrue(g1.toString().equals("50.0 75.0"));
      assertEquals(2, g1.getScoreSize());

      assertTrue(g2.toString().equals("85.0 95.0"));
      assertEquals(2, g2.getScoreSize());
   }

   // Test sum method
   @Test
   public void testSum() {
      assertEquals(125, g1.sum(), 0.0001);
      assertEquals(180, g2.sum(), 0.0001);
   }

   // Test minimum method
   @Test
   public void testMinimum() {
      assertEquals(50, g1.minimum(), 0.001);
      assertEquals(85, g2.minimum(), 0.001);
   }

   // Test finalScore method
   @Test
   public void testFinalScore() {
      assertEquals(75, g1.finalScore(), 0.001); // 125 - 50
      assertEquals(95, g2.finalScore(), 0.001); // 180 - 85
   }
}
