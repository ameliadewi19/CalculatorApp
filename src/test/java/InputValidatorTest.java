import com.calculator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InputValidatorTest {

    @Test
    public void testValidIntegerInput() {
        String input = "10";
        boolean actualResult = InputValidator.isInteger(input);
        boolean expectedResult = true;
        assertTrue(actualResult, "Expected result: " + expectedResult + ", but actual result was: " + actualResult
                + ". Input '" + input + "' should be identified as a valid integer.");
    }

    @Test
    public void testInvalidIntegerInput() {
        String input = "s";
        boolean actualResult = InputValidator.isInteger(input);
        boolean expectedResult = false;
        assertFalse(actualResult, "Expected result: " + expectedResult + ", but actual result was: " + actualResult
                + ". Input '" + input + "' should be identified as an invalid integer.");
    }

    @Test
    public void testNumberOutOfRangeNegative() {
        int number = -32769;
        boolean expectedResult = false; // Expected to be out of range
        boolean actualResult = InputValidator.isInRange(number);
        assertFalse(actualResult, "Expected result: " + expectedResult + ", but was: " + actualResult
                + " for number: " + number + " (should be out of range, below -32768).");
    }

    @Test
    public void testNumberOutOfRangePositive() {
        int number = 32768;
        boolean expectedResult = false; // Expected to be out of range
        boolean actualResult = InputValidator.isInRange(number);
        assertFalse(actualResult, "Expected result: " + expectedResult + ", but was: " + actualResult
                + " for number: " + number + " (should be out of range, above 32767).");
    }

    @Test
    public void testNumberInRange() {
        int number = 298;
        boolean expectedResult = true; // Expected to be within range
        boolean actualResult = InputValidator.isInRange(number);
        assertTrue(actualResult, "Expected result: " + expectedResult + ", but was: " + actualResult
                + " for number: " + number + " (should be within the range of -32768 to 32767).");
    }

    @Test
    public void testValidOperatorDivision() {
        String operator = "/";
        boolean expectedResult = true; // Expected to be a valid operator
        boolean actualResult = InputValidator.isValidOperator(operator);
        assertTrue(actualResult, "Expected result: " + expectedResult + ", but was: " + actualResult
                + " for operator: '" + operator + "' (should be a valid operator).");
    }

    @Test
    public void testInvalidOperatorColon() {
        String operator = ":";
        boolean expectedResult = false; // Expected to be an invalid operator
        boolean actualResult = InputValidator.isValidOperator(operator);
        assertFalse(actualResult, "Expected result: " + expectedResult + ", but was: " + actualResult
                + " for operator: '" + operator + "' (should be an invalid operator).");
    }

    @Test
    public void testInvalidDivisionByZero() {
        int divisor = 0;
        String operator = "/";
        boolean expectedResult = false; // Division by zero should be invalid
        boolean actualResult = InputValidator.isValidDivision(divisor, operator);
        assertFalse(actualResult, "Expected result: " + expectedResult + ", but was: " + actualResult
                + " for divisor: " + divisor + " with operator: '" + operator + "' (should be invalid division).");
    }

    @Test
    public void testValidDivisionNonZeroDivisor() {
        int divisor = 5;
        String operator = "/";
        boolean expectedResult = true; // Division by a non-zero divisor should be valid
        boolean actualResult = InputValidator.isValidDivision(divisor, operator);
        assertTrue(actualResult, "Expected result: " + expectedResult + ", but was: " + actualResult
                + " for divisor: " + divisor + " with operator: '" + operator + "' (should be a valid division).");
    }
}
