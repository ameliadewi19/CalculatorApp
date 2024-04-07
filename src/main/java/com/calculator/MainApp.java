package com.calculator;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 0;
        boolean validInput = false;

        // Loop until valid numbers are input
        while (!validInput) {
            System.out.println("Enter two numbers (ex/ 2 8):");
            String[] inputs = scanner.nextLine().split(" ");

            if (inputs.length != 2 || !InputValidator.isInteger(inputs[0]) || !InputValidator.isInteger(inputs[1])) {
                System.out.println("Invalid input. Please enter valid numbers.");
            } else {
                a = Integer.parseInt(inputs[0]);
                b = Integer.parseInt(inputs[1]);
                if (!InputValidator.isInRange(a) || !InputValidator.isInRange(b)) {
                    System.out.println("Numbers out of range. Please enter numbers in the range of -32,768 to 32,767.");
                } else {
                    validInput = true; // Proceed only if both numbers are valid
                }
            }
        }

        String operator = "";
        // Loop until a valid operator is input
        while (true) {
            System.out.println("Enter the operator (+, -, *, /):");
            operator = scanner.next();
            if (!InputValidator.isValidOperator(operator)) {
                System.out.println("Invalid operator. Only +, -, *, and / are allowed.");
            } else {
                break; // Exit the loop if the operator is valid
            }
        }

        Compute.processOperation(a, b, operator);
    }
}
