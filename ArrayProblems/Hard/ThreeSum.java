import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;

        List<List<Integer>> result = TripletsOptimal(arr);
        System.out.println(result);
    }

    //T.C: O(n log n) + O(n²) = O(n²), S.C: Auxiliary Space Complexity: O(1), Total Space Including Output: O(n²)
    static List<List<Integer>> TripletsOptimal(int[] arr) {

        Arrays.sort(arr);

        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1, k = n - 1;

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return result;
    }



/*// Optimal 3-Sum using sorting + two pointers
// Finds all unique triplets whose sum = 0
// Time Complexity: O(n^2)
// Space Complexity: O(1) extra (excluding result list)

static List<List<Integer>> TripletsOptimal(int[] arr) {

    // Step 1: Sort the array → required for two-pointer search
    // and duplicate skipping
    Arrays.sort(arr);

    int n = arr.length;
    List<List<Integer>> result = new ArrayList<>();

    // Step 2: Fix the first element of the triplet
    for (int i = 0; i < n; i++) {

        // Skip duplicate values for first element
        if (i > 0 && arr[i] == arr[i - 1]) continue;

        // Step 3: Two-pointer search for remaining two elements
        int j = i + 1;      // left pointer
        int k = n - 1;      // right pointer

        while (j < k) {

            // Compute current sum
            int sum = arr[i] + arr[j] + arr[k];

            if (sum < 0) {
                // Need larger sum → move left pointer right
                j++;
            }
            else if (sum > 0) {
                // Need smaller sum → move right pointer left
                k--;
            }
            else {
                // Found valid triplet
                result.add(Arrays.asList(arr[i], arr[j], arr[k]));

                // Move both pointers
                j++;
                k--;

                // Skip duplicates for second element
                while (j < k && arr[j] == arr[j - 1]) j++;

                // Skip duplicates for third element
                while (j < k && arr[k] == arr[k + 1]) k--;
            }
        }
    }

    return result;
}
*/



    /*Complexity
     Time
     Outer loop → n
     Inner loop → n
     Hash lookup → O(1)
     O(n²)

     Space
     HashSet + Result storage → worst case:
     O(n²)*/
    static List<List<Integer>> FindTriplets(int[] arr) {

        int n = arr.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n; i++) {

            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                int third = -(arr[i] + arr[j]);

                if (seen.contains(third)) {

                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    result.add(temp);
                }

                seen.add(arr[j]); // Important
            }
        }
        return new ArrayList<>(result);
    }


    //T.C:O(n^3), S.C:O(n^2)
    static List<List<Integer>> triplet(int[] arr){
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                for (int k = j+1; k < n; k++){
                    if (arr[i]+arr[j]+arr[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);

                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}
