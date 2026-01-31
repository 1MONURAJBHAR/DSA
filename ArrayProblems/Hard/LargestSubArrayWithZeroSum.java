import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {1,-1,3,2,-2,-8,1,7,10,23};
        int ans = LargestSubArrayOptimal(arr);
        System.out.println(ans);
    }

    //T.C:O(n), S.C:O(n)
    static int LargestSubArrayOptimal(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++){
            sum += arr[i];

            if (sum == 0){
                maxLen = i + 1;
            }

            if (map.containsKey(sum)){
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen,len);
            }else{
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    //T.C:O(n^2), S.C:O(1)
    /*Fix starting index i
      Expand ending index j
      Keep running sum
      If sum becomes 0 → update max length*/
    static int LargestSubArray(int[] arr){
       int n = arr.length;
       int maxLen = 0;

       for (int i = 0; i < n; i++){
           int sum = 0;

           for (int j = i; j < n; j++){
               sum += arr[j];

               if (sum == 0){
                   int len = j - i + 1;
                   maxLen =  Math.max(len,maxLen);
               }
           }
       }
       return maxLen;
    }
}
