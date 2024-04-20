import com.calculator.Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void testAddition() {
        assertEquals(1, Calculator.add(-2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(-5, Calculator.subtract(10, 15));
    }

    @Test
    public void testMultiplication() {
        assertEquals(24, Calculator.multiply(-12, -2));
    }

    @Test
    public void testDivision() {
        assertEquals(6.67, Calculator.divide(20, 3));
    }
}
