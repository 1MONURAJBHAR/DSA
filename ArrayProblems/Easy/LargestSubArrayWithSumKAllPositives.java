import java.util.HashMap;

 public class LargestSubArrayWithSumKAllPositives {
    public static void main(String[] args) {
      int[] arr = {1,2,3,1,1,1,1,4,2,3};
//      int ans = LargestLength(arr,3);
//        int ans = LargestLengthBetter(arr, 3);
        int ans = LargestLengthOptimal(arr, 3);
        System.out.println(ans);
    }

    //T.C: O(2n), S.C: O(1)
//this solution is only for when array contains NON-NEGATIVE / POSITIVE numbers (including 0).
    static int LargestLengthOptimal(int[] arr, int k){
        int n = arr.length;
        int maxLen = 0;
        long sum = arr[0];
        int left = 0, right = 0;

        // Expand the window by moving 'right'
        while(right < n){
            // If sum becomes greater than k, shrink the window from the left
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }

            if (sum == k){
                maxLen = Math.max(maxLen, right-left+1);
            }

            right++;

            if (right < n) {
                sum += arr[right];
            }
        }
        return maxLen;
    }






    //Better approach
    // Unordered map:HashMap -> T.C: O(n), for collisions: O(n^2), S.C:O(n)
    //Ordered  map:TreeMap -> T.C: o(n log(n)), S.C:O(n)
     static int LargestLengthBetter(int[] arr, int k) {
        HashMap<Long, Integer> preSumMap = new HashMap<>();

        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: subArray from 0..i has sum = k
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // Case 2: if (sum - k) exists, subArray sum = k
            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Store first occurrence only (important for longest length)
            /*If sum is not already present in the map
              ➜ then store sum -> i
              If it is already present
              ➜ do nothing (we keep the first index)
              So our Java line is perfect for longest subArray sum = K*/
            preSumMap.putIfAbsent(sum, i);
        }

        return maxLen;
    }




    //Brute approach
    //T.C: O(n^2), S.C: O(1)
    static int LargestLength(int[] arr, int k) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }


  /*  static int LargestLength(int[] arr, int k) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;     // reset sum for every starting index i
            int count = 0;   // reset count for every i

            for (int j = i; j < n; j++) {
                sum += arr[j];
                count++;

                if (sum>k) break;

                if (sum == k) {
                    maxLength = Math.max(maxLength, count);
                }
            }
        }

        return maxLength;
    }*/

}
