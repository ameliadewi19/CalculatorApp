package com.calculator;

public class Compute {

    public static void processOperation(int a, int b, String operator) {
        if (!InputValidator.isValidDivision(b, operator)) {
            System.out.println("Division by zero is not allowed.");
            return;
        }

        switch (operator) {
            case "+":
                System.out.println("Result: " + Calculator.add(a, b));
                break;
            case "-":
                System.out.println("Result: " + Calculator.subtract(a, b));
                break;
            case "*":
                System.out.println("Result: " + Calculator.multiply(a, b));
                break;
            case "/":
                System.out.println("Result: " + Calculator.divide(a, b));
                break;
        }
    }
}
