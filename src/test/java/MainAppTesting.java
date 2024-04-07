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

    @BeforeEach // Updated from @Before to @BeforeEach
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

    @AfterEach // Updated from @After to @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testCaseWithInvalidNumberInput() {
        provideInput("10 a\n"); // Make sure to simulate the newline as would be entered in the console
        MainApp.main(new String[]{});
        assertTrue(getOutput().contains("Invalid input. Please enter valid numbers."));
    }

    @Test
    public void testCaseWithInvalidFirstInput() {
        // Simulate user input of "+" and "5" with line separators to mimic pressing enter after each input
        provideInput("+ 5\n");
        // Run the main method of your app to process the inputs
        MainApp.main(new String[]{});
        // Assert that the output contains the expected error message
        assertTrue(getOutput().contains("Invalid input. Please enter valid numbers."));
    }

    @Test
    public void testCaseWithOutOfRangeInput() {
        // Simulate user input of "-32769" and "12" with line separators
        provideInput("-32769 12\n");
        // Run the main method of your app to process the inputs
        MainApp.main(new String[]{});
        // Assert that the output contains the expected error message
        assertTrue(getOutput().contains("Numbers out of range. Please enter numbers in the range of -32,768 to 32,767."));
    }

    @Test
    public void testCaseWithNumberOutOfRange() {
        // Simulate user input of "32768" and "12", separated by space
        provideInput("32768 12\n");
        // Run the main method of your app to process the inputs
        MainApp.main(new String[]{});
        // Assert that the output contains the expected error message for out-of-range number
        assertTrue(getOutput().contains("Numbers out of range. Please enter numbers in the range of -32,768 to 32,767."));
    }

    @Test
    public void testCaseWithInvalidOperator() {
        // Simulate user input of "2" and "12" for the numbers, followed by ":" as the operator
        provideInput("2 12\n:\n");
        // Run the main method of your app to process the inputs
        MainApp.main(new String[]{});
        // Assert that the output contains the expected error message for invalid operator
        assertTrue(getOutput().contains("Invalid operator. Only +, -, *, and / are allowed."));
    }

    @Test
    public void testCaseWithLiteralOperator() {
        // Simulate user input of "2" and "12" for the numbers, followed by "kurang" as the operator
        provideInput("2 12\nkurang\n");
        // Run the main method of your app to process the inputs
        MainApp.main(new String[]{});
        // Assert that the output contains the expected error message for an invalid operator
        assertTrue(getOutput().contains("Invalid operator. Only +, -, *, and / are allowed."));
    }

    @Test
    public void testCaseContinuesToProcessOperation() {
        provideInput("15 12\n+\n");
        MainApp.main(new String[]{});

        // Verifikasi bahwa tidak ada pesan error validasi dan asumsikan bahwa proses operasi berjalan.
        // Anda bisa menambahkan pengecekan khusus untuk memastikan pesan "Result:" muncul jika itu bagian dari logika Compute.processOperation
        assertFalse(getOutput().contains("Invalid input"));
        assertFalse(getOutput().contains("Invalid operator"));
        assertFalse(getOutput().contains("Numbers out of range"));
        // Ini mengecek adanya output yang diharapkan, yang mengimplikasikan operasi dijalankan
        assertTrue(getOutput().contains("Result:"));
    }

}
