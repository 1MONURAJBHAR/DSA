import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Problem:
 Rearrange array elements so that positive and negative numbers appear alternately.

 Note:
 This file demonstrates multiple variants.
 - Some solutions work ONLY when the number of positives equals the number of negatives.
 -This implementation works only when the number of positives equals the number of negatives (or differs by at most what the problem guarantees).
 -This works perfectly under this constraint: Number of positives == number of negatives,(or the problem guarantees strict alternation starting with positive)
 - These are NOT general-purpose solutions.
*/
public class RearrangeAlternatePositiveAndNegativeV2 {
    public static void main(String[] args) {
//        int[] arr = {3,1,-2,-5,2,-4};
        int[] arr = {1,2,-4,-5,3,6};
//        int[] ans = OptimalVariety1(arr);
//        RearrangeArrayForLoop(arr);
        RearrangeArrayWhileLoop(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        Variant 1 (Index-jump approach):
        - Places positives at even indices and negatives at odd indices.
        - Works ONLY when positives and negatives are equal in count
          (or the problem explicitly guarantees this).

        Time Complexity: O(n)
        Space Complexity: O(n)
       */
    static int[] OptimalVariety1(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int num : arr) {
            if (num < 0) {
                ans[negIndex] = num;
                negIndex += 2;
            } else {
                ans[posIndex] = num;
                posIndex += 2;
            }
        }
        return ans;
    }

      /*
     Variant 2 (Two-list merge without leftovers handling):
     - Preserves order
     - Alternates only while both lists have elements
     - Assumes positives == negatives

     Time Complexity: O(n)+O(n/2) === O(n)
     Space Complexity: O(n)
    */
    static void RearrangeArrayWhileLoop(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // separate the positives & negatives.
        for (int x : arr) {
            if (x >= 0) {
                pos.add(x);
            } else {
                neg.add(x);
            }
        }

        int i = 0, p = 0, q = 0;

        // Place elements alternately (no leftover handling here)
        while (p < pos.size() && q < neg.size()) {
            arr[i++] = pos.get(p++);
            arr[i++] = neg.get(q++);
        }
    }


    /*
     Variant 3 (For-loop index arithmetic):
     - Directly places elements at fixed positions
     - Assumes equal number of positives and negatives

     Time Complexity: O(n)+O(n/2) === O(n)
     Space Complexity: O(n)
    */
    static void RearrangeArrayForLoop(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // separate the positives & negatives.
        for (int x : arr) {
            if (x >= 0) {
                pos.add(x);
            } else {
                neg.add(x);
            }
        }

        // requires pos.size() == neg.size()
        for (int i = 0; i < arr.length/2; i++){
            arr[i*2] = pos.get(i);  //positives on even places: 0,2,4
            arr[i*2+1] = neg.get(i);   //negatives on odd places: 1,3,5
        }
    }
}
