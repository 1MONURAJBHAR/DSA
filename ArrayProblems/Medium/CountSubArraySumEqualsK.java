import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumEqualsK {
    public static void main(String[] args) {
       int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int ans = CountSubArrayOptimal(arr,3);
        System.out.println("Subarrays count is: "+ans);
    }

    //T.C:O(n), S.C:O(n)
    static int CountSubArrayOptimal(int[] arr, int k){
        int n = arr.length;
        int count = 0;
        int sum = 0;  // Running prefix sum

        // HashMap -> (prefixSum -> frequency of prefixSum)
        Map<Integer,Integer> map = new HashMap<>();

        // Base case:
        // Prefix sum 0 occurs once (important for subarrays starting from index 0)
        map.put(0,1);

        for (int num: arr){
            sum += num;

        /*
         If (sum - k) exists in map,
         it means there was a previous prefix sum such that:
         currentSum - previousSum = k
         => subarray sum = k
        */
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

        /*
         Store current prefix sum in map
         Increase frequency if already exists
        */
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        return count;
    }


    //T.C: O(n^2) S.C:(1)
    static int CountSubArrays(int[] arr,int k){
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
