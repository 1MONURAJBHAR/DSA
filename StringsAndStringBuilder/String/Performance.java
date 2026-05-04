package String;

/**
 * Demonstrates performance impact of String concatenation in Java.
 *
 * Key Concept:
 * - Strings are immutable → every concatenation creates a NEW object.
 * - This leads to multiple objects in memory and poor performance in loops.
 *
 * Time Complexity:
 * - O(n²) due to repeated copying of characters
 */
public class Performance {

    public static void main(String[] args) {

        // Initial string (starts with a space)
        String str = " ";

        // Loop from 1 to 9
        for (int i = 1; i < 10; i++) {

            // Each iteration creates a NEW String object
            // Old string is not modified (immutability)
            // Internally: new StringBuilder → append → toString()
            str = str + i;
        }

        // Final output after all concatenations
        System.out.println(str);   // Output: " 123456789"
    }
}