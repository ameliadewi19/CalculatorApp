package com.calculator;

public class InputValidator {

    // Method to check if a string is an integer
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to check if an integer is within the valid range
    public static boolean isInRange(int number) {
        return number >= -32768 && number <= 32767;
    }

    // Validate the operator
    public static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    // Validate division by zero
    public static boolean isValidDivision(int divisor, String operator) {
        return !(operator.equals("/") || divisor == 0);
    }
}
