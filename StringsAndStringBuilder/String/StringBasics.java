package String;

import java.util.Scanner;

//  "Strings in java are immutable means they cannot be modified."

/**
 * This class demonstrates basic String operations in Java.
 * Covers:
 * 1. Input methods (next vs nextLine)
 * 2. charAt() and length()
 * 3. indexOf()
 * 4. compareTo()
 */
public class StringBasics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /* =========================
           1. STRING INPUT METHODS
           ========================= */

        // next() -> reads only a single word (stops at space)
        // Example: Input: "Hello World" -> Output: "Hello"

        // String word = sc.next();
        // System.out.println("Word input : " + word);

        // nextLine() -> reads full line including spaces
        // Example: Input: "Hello World" -> Output: "Hello World"

        // String line = sc.nextLine();

        // System.out.println("Full line input: " + line);


        /* =========================
           2. charAt() & length()
           ========================= */

        // String str1 = "Hello world"; // space is also counted
        // char ch = str1.charAt(6);    // returns character at index 6
        // System.out.println("Character at index 6: " + ch);

        // length() returns total number of characters
        // System.out.println("Length of string: " + str1.length());


        /* =========================
           3. indexOf()
           ========================= */

        // Returns index of first occurrence of given character
        // If not found, returns -1
        // int index = str1.indexOf('l');
        // System.out.println("First occurrence of 'l': " + index);


        /* =========================
           4. compareTo()
           ========================= */

        // Compares two strings lexicographically (dictionary order)
        // Returns:
        // 0  -> if both strings are equal
        // >0 -> if first string is greater
        // <0 -> if first string is smaller

      /*  String str = "Hello";
        String gtr = "Hdllo";

        int result = str.compareTo(gtr);

        System.out.println("Comparison result: " + result);*/

        // Explanation:
        // 'e' (ASCII 101) vs 'd' (ASCII 100)
        // So "Hello" > "Hdllo" -> result will be positive


         /* =========================
           5. contains(), startsWith(), endsWith()
           ========================= */

        /*String text = "Hello World";

        // contains() -> checks if substring exists anywhere in string
        System.out.println("Contains 'World': " + text.contains("World")); // true
        System.out.println("Contains 'world': " + text.contains("world")); // false (case-sensitive)

        // startsWith() -> checks if string starts with given prefix
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello")); // true
        System.out.println("Starts with 'He': " + text.startsWith("He"));       // true
        System.out.println("Starts with 'World': " + text.startsWith("World")); // false

        // endsWith() -> checks if string ends with given suffix
        System.out.println("Ends with 'World': " + text.endsWith("World")); // true
        System.out.println("Ends with 'ld': " + text.endsWith("ld"));       // true
        System.out.println("Ends with 'Hello': " + text.endsWith("Hello")); // false*/


        /* =========================
          6. toUpperCase(), toLowerCase(), concat()
          ========================= */

        String sample = "Java Programming";

        // toUpperCase() -> converts entire string to uppercase
        String upper = sample.toUpperCase();
        System.out.println("Uppercase: " + upper);

        // toLowerCase() -> converts entire string to lowercase
        String lower = sample.toLowerCase();
        System.out.println("Lowercase: " + lower);

        // concat() -> joins two strings
        String s1 = "Java";
        String s2 = " Programming";

        String combined = s1.concat(s2);   //A new string is formed that contains mixture of s1 & s2. since strings are immutable in java.
        System.out.println("Concatenated string: " + combined);

        // Note: + operator can also be used for concatenation
        String combined2 = s1 + s2;      //A new string is formed that contains mixture of s1 & s2. since strings are immutable in java
        System.out.println("Using + operator: " + combined2);


        sc.close(); // Always close Scanner to avoid resource leak
    }
}