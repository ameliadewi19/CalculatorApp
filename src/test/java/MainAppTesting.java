import com.calculator.MainApp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainAppTesting {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testCaseWithInvalidNumberInput() {
        provideInput("10 a\n");
        MainApp.main(new String[]{});
        String actualOutput = getOutput();
        String expectedMessage = "Invalid input. Please enter valid numbers.";
        assertTrue(actualOutput.contains(expectedMessage), 
            "Expected output to contain: '" + expectedMessage + "', but actual output was: '" + actualOutput + "'");
    }

    @Test
    public void testCaseWithInvalidFirstInput() {
        provideInput("+ 5\n");
        MainApp.main(new String[]{});
        String actualOutput = getOutput();
        String expectedMessage = "Invalid input. Please enter valid numbers.";
        assertTrue(actualOutput.contains(expectedMessage), 
            "Expected output to contain: '" + expectedMessage + "', but actual output was: '" + actualOutput + "'");
    }

    @Test
    public void testCaseWithOutOfRangeInput() {
        provideInput("-32769 12\n");
        MainApp.main(new String[]{});
        String actualOutput = getOutput();
        String expectedMessage = "Numbers out of range. Please enter numbers in the range of -32,768 to 32,767.";
        assertTrue(actualOutput.contains(expectedMessage),
            "Expected output to contain: '" + expectedMessage + "', but actual output was: '" + actualOutput + "'");
    }

    @Test
    public void testCaseWithNumberOutOfRange() {
        provideInput("32768 12\n");
        MainApp.main(new String[]{});
        String actualOutput = getOutput();
        String expectedMessage = "Numbers out of range. Please enter numbers in the range of -32,768 to 32,767.";
        assertTrue(actualOutput.contains(expectedMessage),
            "Expected output to contain: '" + expectedMessage + "', but actual output was: '" + actualOutput + "'");
    }

    @Test
    public void testCaseWithInvalidOperator() {
        provideInput("2 12\n:\n");
        MainApp.main(new String[]{});
        String actualOutput = getOutput();
        String expectedMessage = "Invalid operator. Only +, -, *, and / are allowed.";
        assertTrue(actualOutput.contains(expectedMessage),
            "Expected output to contain: '" + expectedMessage + "', but actual output was: '" + actualOutput + "'");
    }

    @Test
    public void testCaseWithLiteralOperator() {
        provideInput("2 12\nkurang\n");
        MainApp.main(new String[]{});
        String actualOutput = getOutput();
        String expectedMessage = "Invalid operator. Only +, -, *, and / are allowed.";
        assertTrue(actualOutput.contains(expectedMessage),
            "Expected output to contain: '" + expectedMessage + "', but actual output was: '" + actualOutput + "'");
    }

    @Test
    public void testCaseContinuesToProcessOperation() {
        provideInput("15 12\n+\n");
        MainApp.main(new String[]{});
        String actualOutput = getOutput();
        String noErrorMessage = "Invalid input or operator or range error.";
        String expectedPositiveMessage = "Result:";
        assertFalse(actualOutput.contains(noErrorMessage),
            "Unexpected error message found: '" + noErrorMessage + "' in actual output: '" + actualOutput + "'");
        assertTrue(actualOutput.contains(expectedPositiveMessage),
            "Expected output to contain: '" + expectedPositiveMessage + "', but actual output was: '" + actualOutput + "'");
    }
}
