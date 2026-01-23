package basics;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Enter operator (+, -, *, /, %, x to exit): ");
            char ch = sc.next().trim().charAt(0);

            if (ch == 'x' || ch == 'X') {
                System.out.println("Calculator closed.");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = sc.nextDouble();

            double ans;
            String text;

            if (ch == '+') {
                ans = num1 + num2;
                text = "Addition";
            } else if (ch == '-') {
                ans = num1 - num2;
                text = "Subtraction";
            } else if (ch == '*') {
                ans = num1 * num2;
                text = "Multiplication";
            } else if (ch == '/') {
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed!");
                    continue;
                }
                ans = num1 / num2;
                text = "Division";
            } else if (ch == '%') {
                if (num2 == 0) {
                    System.out.println("Error: Modulo by zero is not allowed!");
                    continue;
                }
                ans = num1 % num2;
                text = "Remainder";
            } else {
                System.out.println("Invalid operator!");
                continue;
            }

            System.out.println(text + " of two numbers is: " + ans);
            System.out.println("-----------------------------------");
        }
        sc.close();
    }
}
