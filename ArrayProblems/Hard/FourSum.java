import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        List<List<Integer>> ans = Quart3(arr,0);
        System.out.println(ans);
    }

    /*Sorting = O(n log n)
      Two loops + two-pointer = O(n^3)
      Total Time = O(n^3)
      Space = O(1) extra (excluding output)
    */
    // Optimal 4-Sum using sorting + two pointers
    // Time Complexity: O(n^3)
    // Space Complexity: O(1) extra (excluding result list)
    static List<List<Integer>> Quart3(int[] arr, int target) {

        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        // Sort array → required for two-pointer + duplicate skipping
        Arrays.sort(arr);

        // Fix first element
        for (int i = 0; i < n; i++) {

            // Skip duplicates for first index
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Fix second element
            for (int j = i + 1; j < n; j++) {

                // Skip duplicates for second index
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                // Two pointer search for remaining two numbers
                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    // Use long to prevent integer overflow
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];

                    if (sum < target) {
                        k++;   // need larger sum
                    }
                    else if (sum > target) {
                        l--;   // need smaller sum
                    }
                    else {
                        // Found valid quadruplet
                        result.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));

                        k++;
                        l--;

                        // Skip duplicates for third index
                        while (k < l && arr[k] == arr[k - 1]) k++;

                        // Skip duplicates for fourth index
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    }
                }
            }
        }

        return result;
    }




    // Better approach using hashing
    // Time Complexity: O(n^3)
    // Space Complexity: O(n) + O(number of unique quadruplets)
    static List<List<Integer>> Quart2(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                Set<Integer> seen = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    long fourth = (long) target - (arr[i] + arr[j] + arr[k]);

                    if (fourth >= Integer.MIN_VALUE && fourth <= Integer.MAX_VALUE && seen.contains((int) fourth)) {

                        List<Integer> quad = Arrays.asList(arr[i],arr[j],arr[k],(int) fourth);
                        Collections.sort(quad);
                        result.add(quad);

                    }
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(result);
    }


















    //Brute force, T.C: O(n^4), S.C:Auxiliary Space = O(n),where k = number of unique quadruplets,Worst case → O(n³)
    static List<List<Integer>> Quart(int[] arr, int target){
        int n = arr.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                for (int k = j+1; k < n; k++){
                    for (int l = k+1; l < n; l++){
                        long sum = (long)arr[i]+arr[j]+arr[k]+arr[l];
                        if (sum == target){
                            List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(temp);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
