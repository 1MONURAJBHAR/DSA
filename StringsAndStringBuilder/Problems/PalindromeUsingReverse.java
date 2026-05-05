/**
 * Uses reverse() to check palindrome.
 * Time: O(n), Space: O(n)
 */
public class PalindromeUsingReverse {

    public static void main(String[] args) {
        String str = "madam";

        String reversed = new StringBuilder(str).reverse().toString();

        if (str.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}