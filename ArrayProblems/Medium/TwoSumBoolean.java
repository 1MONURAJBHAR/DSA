import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumBoolean {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;

//        boolean ans = Sum(arr,target);
          boolean ans = twoSumOptimal(arr,target);
//        boolean ans = SumBetter(arr,target);
        System.out.println(ans);
    }

    //T.C:O(n)+O(n log(n) ), S.C:O(1)
    static boolean twoSumOptimal(int[] arr, int target){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            int sum = arr[left]+arr[right];

            if (sum == target) return true;

            if (sum>target) right--;
            else left++;

        }
        return false;
    }

    //Better approach, T.C: O(n) for best&avg case, worst case: O(n^2), S.C:O(n)
    static boolean SumBetter(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];

            if (map.containsKey(need)) {
                return true;
            }

            map.put(arr[i], i); // store element with its index
        }

        return false;
    }

    //T.C: O(n^2), S.C: O(1)
    static boolean Sum(int[] arr, int target) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) return true;
            }
        }
        return false;
    }

}
