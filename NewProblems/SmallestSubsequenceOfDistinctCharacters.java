import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {

        // last[i] stores the last occurrence index of character ('a' + i)
        int[] last = new int[26];

        // Find the last occurrence of every character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // visited[i] = true if the character is already present in the stack
        boolean[] visited = new boolean[26];

        // Monotonic stack to build the lexicographically smallest subsequence
        Stack<Character> stack = new Stack<>();

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Skip the character if it is already included
            if (visited[ch - 'a']) {
                continue;
            }

            /*
             * Remove characters from the top of the stack while:
             * 1. Stack is not empty.
             * 2. Current character is lexicographically smaller than stack top.
             * 3. Stack top appears again later (safe to remove now).
             */
            while (!stack.isEmpty()
                    && ch < stack.peek()
                    && last[stack.peek() - 'a'] > i) {

                // Mark the removed character as not visited
                visited[stack.pop() - 'a'] = false;
            }

            // Add current character to the answer
            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        // Convert stack into the final string
        StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
}
