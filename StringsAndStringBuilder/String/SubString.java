package String;

/**
 * Demonstrates usage of String.substring() method in Java.
 *
 * substring(beginIndex, endIndex) -> returns characters from beginIndex (inclusive)
 *                                   to endIndex (exclusive)
 *
 * substring(beginIndex) -> returns characters from beginIndex to end of string
 */
public class SubString {

    public static void main(String[] args) {

        // Original string
        String str = "abcde";

        // Case 1: substring(0, 3)
        // Returns characters from index 0 to 2 (endIndex is excluded)
        // Output: "abc"
        System.out.println(str.substring(0, 3));

        // Case 2: substring(0, 0)
        // Start and end index are same → returns empty string ""
        System.out.println(str.substring(0, 0));

        // Case 3: substring(2)
        // Returns substring from index 2 to end of string
        // Output: "cde"
        System.out.println(str.substring(2));
    }
}