import java.util.Arrays;
import java.util.Stack;

/*
* Remove consecutive duplicate elements using a stack
Example:
[1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2]
Output → [1, 3, 5, 2]
* */
public class RemoveConsecutiveSubSequences {

    public static int[] removeDuplicates(int[] num) {
        Stack<Integer> st = new Stack<>();

        int i = 0;
        while (i < num.length) {

            // If stack is empty OR top is not equal → push
            if (st.isEmpty() || st.peek() != num[i]) {
                st.push(num[i]);
                i++;
            } else {
                // If duplicate sequence found
                int val = num[i];

                // Skip all duplicates
                while (i < num.length && num[i] == val) {
                    i++;
                }

                // Remove the previous occurrence from stack
                st.pop();
            }
        }

        // Convert stack to array
        int[] result = new int[st.size()];
        for (int j = result.length - 1; j >= 0; j--) {
            result[j] = st.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2};

        int[] res = removeDuplicates(arr);

        System.out.println(Arrays.toString(res));
    }
}
