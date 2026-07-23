public class NonRepeatingCharacter {
    public char nonRepeatingChar(String s) {
        // code here
        int[] freq = new int[26];

        // Count frequencies
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return '$';
    }
}
