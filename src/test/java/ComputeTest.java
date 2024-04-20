import com.calculator.Compute;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ComputeTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach // Updated from @Before to @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach // Updated from @After to @AfterEach
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void testDivisionByZero() {
        int a = 4;
        int b = 0;
        String operator = "/";
        String expectedOutput = "Division by zero is not allowed.";
        // Simulate user input for division by zero
        Compute.processOperation(a, b, operator);

        assertTrue(getOutput().contains(expectedOutput));
    }

    @Test
    public void testAddition() {
        int a = 20;
        int b = 35;
        String operator = "+";
        String expectedOutput = "Result: 55";

        Compute.processOperation(a, b, operator);

        assertTrue(getOutput().contains(expectedOutput));
    }

    @Test
    public void testSubtraction() {
        int a = 700;
        int b = 37;
        String operator = "-";
        String expectedOutput = "Result: 663";

        Compute.processOperation(a, b, operator);

        assertTrue(getOutput().contains(expectedOutput));
    }

    @Test
    public void testMultiplication() {
        int a = 20;
        int b = 5;
        String operator = "*";
        String expectedOutput = "Result: 100";

        Compute.processOperation(a, b, operator);

        assertTrue(getOutput().contains(expectedOutput));
    }

    @Test
    public void testDivision() {
        int a = 10;
        int b = 3;
        String operator = "/";
        String expectedOutput = "Result: 3.33";

        Compute.processOperation(a, b, operator);

        assertTrue(getOutput().contains(expectedOutput));
    }
}
