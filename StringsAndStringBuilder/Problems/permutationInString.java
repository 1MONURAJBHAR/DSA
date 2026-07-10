public class permutationInString {

    public static void main(String[] args) {

        // Test Case 1
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2)); // true

        // Test Case 2
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2)); // false

        // Test Case 3
        s1 = "adc";
        s2 = "dcda";
        System.out.println(checkInclusion(s1, s2)); // true

        // Test Case 4
        s1 = "hello";
        s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2)); // false
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Frequency of s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            windowCount[s2.charAt(right) - 'a']++;

            // Keep window size equal to s1.length()
            if (right - left + 1 > s1.length()) {
                windowCount[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare frequencies
            if (right - left + 1 == s1.length()) {
                if (matches(s1Count, windowCount)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}