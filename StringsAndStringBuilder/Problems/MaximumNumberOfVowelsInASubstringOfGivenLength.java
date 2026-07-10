public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = 0;

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        maxCount = count;

        // Slide the window
        for (int i = k; i < s.length(); i++) {

            // Remove left character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            // Add right character
            if (isVowel(s.charAt(i))) {
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // Helper method to check vowel
    public static boolean isVowel(char ch) {
        return ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u';
    }

    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println(maxVowels(s1, k1)); // Output: 3

        String s2 = "aeiou";
        int k2 = 2;
        System.out.println(maxVowels(s2, k2)); // Output: 2

        String s3 = "leetcode";
        int k3 = 3;
        System.out.println(maxVowels(s3, k3)); // Output: 2

        String s4 = "rhythms";
        int k4 = 4;
        System.out.println(maxVowels(s4, k4)); // Output: 0
    }
}