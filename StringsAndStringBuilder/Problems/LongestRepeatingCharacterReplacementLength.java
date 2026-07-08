public class LongestRepeatingCharacterReplacementLength {
   /*Brute Force Solution (Java)
    The brute-force approach checks every possible substring and determines whether it can be made of the same character using at most k replacements.
    Idea
    Start from every index i.
    Extend the substring to every index j.
    Maintain the frequency of characters in the current substring.
    Find the maximum frequency (maxFreq) in the substring.
    If --> substring length - maxFreq <= k --> then update the answer.*/
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'A';
                freq[index]++;

                maxFreq = Math.max(maxFreq, freq[index]);

                int length = j - i + 1;

                if (length - maxFreq <= k) {
                    ans = Math.max(ans, length);
                }
            }
        }

        return ans;
    }

    /*Start

Expand right
        │
        ▼
Increase frequency
        │
        ▼
Update maxFreq
        │
        ▼
Need = Window Size - maxFreq
        │
        ▼
Need <= k ?
   │            │
 Yes           No
 │              │
 ▼              ▼
Update       Move left
Answer       until valid

If we recomputed maxFreq every time we shrank the window, we'd need to scan the frequency array repeatedly, making the solution slower.
Keeping the highest value seen so far allows the algorithm to stay O(n) while still producing the correct answer.

Complexity
Time: O(n) — each character enters and leaves the window at most once.
Space: O(1) — the frequency array has a fixed size of 26.
*/

    public int characterReplacement2(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Increase frequency of current character
            freq[s.charAt(right) - 'A']++;

            // Update maximum frequency in the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If more than k replacements are needed, shrink the window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);

        System.out.println("Longest Repeating Character Replacement Length = " + result);
    }
}
