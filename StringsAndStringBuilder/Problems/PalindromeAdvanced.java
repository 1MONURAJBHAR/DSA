/**
 * Ignores case and non-alphanumeric characters.
 * Example: "A man, a plan, a canal: Panama" → Palindrome
 */
public class PalindromeAdvanced {

    public static boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {

            char l = s.charAt(left);
            char r = s.charAt(right);

            // Skip non-alphanumeric
            if (!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }

            // Compare (case-insensitive)
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(str) ? "Palindrome" : "Not Palindrome");
    }
}