public class BuddyString {

    // This method checks whether two strings can become equal
    // by swapping exactly one pair of characters in string s.
    public static boolean buddyStrings(String s, String goal) {

        // If the lengths are different, they can never be equal.
        if (s.length() != goal.length()) {
            return false;
        }

        // Case 1: Both strings are already equal.
        if (s.equals(goal)) {

            // Count the frequency of each character.
            int[] freq = new int[26];

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;

                // If any character appears more than once,
                // swapping those identical characters keeps the string unchanged.
                if (freq[ch - 'a'] > 1) {
                    return true;
                }
            }

            // No duplicate characters, so a swap will always change the string.
            return false;
        }

        // Store the indices where the characters are different.
        int first = -1;
        int second = -1;

        // Find all mismatched positions.
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {

                // Store the first mismatch.
                if (first == -1) {
                    first = i;
                }
                // Store the second mismatch.
                else if (second == -1) {
                    second = i;
                }
                // More than two mismatches means one swap cannot fix it.
                else {
                    return false;
                }
            }
        }

        // Check whether swapping the two mismatched characters
        // makes both strings equal.
        return second != -1 &&
                s.charAt(first) == goal.charAt(second) &&
                s.charAt(second) == goal.charAt(first);
    }

    public static void main(String[] args) {

        // Example 1
        String s = "ab";
        String goal = "ba";

        System.out.println("Example 1");
        System.out.println("String 1 : " + s);
        System.out.println("String 2 : " + goal);
        System.out.println("Result   : " + buddyStrings(s, goal));

        // Example 2
        s = "ab";
        goal = "ab";

        System.out.println("\nExample 2");
        System.out.println("String 1 : " + s);
        System.out.println("String 2 : " + goal);
        System.out.println("Result   : " + buddyStrings(s, goal));

        // Example 3
        s = "aa";
        goal = "aa";

        System.out.println("\nExample 3");
        System.out.println("String 1 : " + s);
        System.out.println("String 2 : " + goal);
        System.out.println("Result   : " + buddyStrings(s, goal));
    }
}