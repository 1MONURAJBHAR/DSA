package String;

import java.util.Scanner;

/**
 * This class demonstrates how Java handles
 * String + int + char concatenation.
 *
 * Key Concept:
 * Java evaluates expressions from LEFT → RIGHT
 * when String is involved.
 */
public class StringIntChar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = "abc";

        // Appending different data types to string
        // str += "xyz";  // abcxyz
        // str += 'r';    // abc r
        // str += 10;     // abc10


        /* =========================
           BASIC CONCATENATION
           ========================= */

        System.out.println("abc" + 10);     // "abc10"
        System.out.println("abc" + "xyz");  // "abcxyz"
        System.out.println("abc" + 'r');    // "abcr"


        /* =========================
           LEFT TO RIGHT EVALUATION
           ========================= */

        // Step 1: "abc" + 10  → "abc10"
        // Step 2: "abc10" + 20 → "abc1020"
        System.out.println("abc" + 10 + 20);

        // (10 + 20) = 30 first, then concatenated
        // "abc" + 30 → "abc30"
        System.out.println("abc" + (10 + 20));

        // Step 1: 10 + 20 = 30 (both are integers)
        // Step 2: 30 + "abc" → "30abc"
        System.out.println(10 + 20 + "abc");


        /* =========================
           IMPORTANT RULE
           ========================= */

        // If ANY operand is String → result becomes String
        // After that, all + operations are treated as concatenation

        sc.close();
    }
}