import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Problem:
 Rearrange an array so that positive and negative numbers appear alternately,
 while preserving their relative order. The counts of positives and negatives
 may be unequal.

 Approach:
 1. Store positive and negative numbers in separate lists (order preserved).
 2. Merge the two lists alternately into the original array.
 3. Append remaining elements if one list is longer.

 Time Complexity: O(2n) === O(n)
 Space Complexity: O(n)
*/
//This solution handles unequal counts and preserves order using a two-list merge approach in O(n) time.
public class RearrangeAlternatePositiveAndNegativeV1 {
    public static void main(String[] args) {
//       int[] arr = {3,1,-2,-5,2,-4};
       int[] arr = {1,2,-4,-5,3,6};
        rearrangeArrayWhileLoop(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
         General solution (recommended):
         - Preserves relative order
         - Handles unequal counts safely
         - Simple and robust
        */
    static void rearrangeArrayWhileLoop(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positive and negative numbers
        for (int x : arr) {
            if (x >= 0) {
                pos.add(x);
            } else {
                neg.add(x);
            }
        }

        int i = 0, p = 0, q = 0;

        // Place elements alternately while both lists have elements
        while (p < pos.size() && q < neg.size()) {
            arr[i++] = pos.get(p++);
            arr[i++] = neg.get(q++);
        }

        // Append remaining positive elements (if any)
        while (p < pos.size()) {
            arr[i++] = pos.get(p++);
        }

        // Append remaining negative elements (if any)
        while (q < neg.size()) {
            arr[i++] = neg.get(q++);
        }
    }

    /*
      Alternative implementation using index arithmetic.
      Works correctly but is more complex than the while-loop approach.
     */
    static int[] rearrangeArrayForLoop(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positives and negatives
        for (int x : arr) {
            if (x > 0) {
                pos.add(x);
            } else {
                neg.add(x);
            }
        }

        // Case 1: More positives than negatives
        if (pos.size() > neg.size()) {

            // Place alternating pos & neg
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }

            // Place remaining positives
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index++] = pos.get(i);
            }

        }
        // If negatives are more or equal
        else {

            // Place alternating pos & neg
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }

            // Place remaining negatives
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index++] = neg.get(i);
            }
        }

        return arr;
    }

}
