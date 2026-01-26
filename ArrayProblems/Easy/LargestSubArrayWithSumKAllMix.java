import java.util.HashMap;

public class LargestSubArrayWithSumKAllMix {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,0,0,0,1,4,2,3};
//        Longest subArray with sum = 3 is: {3, 0, 0, 0}
//        int ans = longestSubArrayWithSumK(arr, 3);
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int ans = longestSubArrayWithSumK(arr, 3);
        System.out.println(ans);
    }


    //Same solution is optimal for all mix: 0s,+ve,-ve,
    // Unordered map:HashMap -> T.C: O(n), for collisions: O(n^2), S.C:O(n)
    //Ordered  map:TreeMap -> T.C: o(n log(n)), S.C:O(n)
    static int longestSubArrayWithSumK(int[] arr, int k) {
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
}
