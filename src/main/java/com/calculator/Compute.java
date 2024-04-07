package com.calculator;

public class Compute {

    public static void processOperation(int a, int b, String operator) {
        if (!InputValidator.isValidDivision(b, operator)) {
            System.out.println("Division by zero is not allowed.");
            return;
        }

        switch (operator) {
            case "+":
                System.out.println("Result: " + (a + b));
                break;
            case "-":
                System.out.println("Result: " + (a - b));
                break;
            case "*":
                System.out.println("Result: " + (a * b));
                break;
            case "/":
                System.out.println("Result: " + ((double) a / b));
                break;
            default:
                // Though we've already validated this, it's good practice to have a default case
                System.out.println("Invalid operator. Only +, -, *, and / are allowed.");
        }
    }
}
