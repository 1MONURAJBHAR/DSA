import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordII {

    // Returns the minimum number of key presses required
    // to type the given word on a remapped phone keypad.
    // Time Complexity: O(n + 26 log 26) ≈ O(n)
    // Space Complexity: O(26) ≈ O(1)
    public int minimumPushes(String word) {

        // Stores the frequency of each lowercase letter ('a' to 'z')
        int[] freq = new int[26];

        // Count the frequency of every character in the word
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies in ascending order so that
        // the highest frequencies are placed at the end
        Arrays.sort(freq);

        // Current push count assigned to a group of characters
        int pushes = 1;

        // Counts how many characters have been assigned
        // the current push count
        int count = 0;

        // Stores the minimum total number of key presses
        int result = 0;

        // Traverse frequencies from highest to lowest
        for (int i = 25; i >= 0; i--) {

            // Stop when no more characters are present
            if (freq[i] == 0)
                break;

            // Add the total pushes required for the current character
            // (frequency × assigned push count)
            result += freq[i] * pushes;

            // One more character has been assigned
            count++;

            // Each push level can accommodate only 8 characters.
            // After assigning 8 characters, increase the push count.
            if (count == 8) {
                pushes++;
                count = 0;
            }
        }

        // Return the minimum number of pushes required
        return result;
    }
}