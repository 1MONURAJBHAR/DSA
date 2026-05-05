//Reverse a string
//Check palindrome
//Toggle case (like you wrote 👍)
//Remove duplicates
//Count characters / frequency
//Anagram check (basic version)
//String compression (simple)

/**
 * Checks palindrome using two-pointer technique.
 * Time: O(n), Space: O(1)
 */
public class CheckPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Optional: ignore spaces (uncomment if needed)
            // while (left < right && s.charAt(left) == ' ') left++;
            // while (left < right && s.charAt(right) == ' ') right--;

            // Compare characters
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "madam";

        if (isPalindrome(str)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
