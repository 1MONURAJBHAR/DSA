import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIndex {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target = 14;

         int[] ans = ReturnIndexSum(arr,target);
//        int[] ans = SumOptimal(arr,target);
        System.out.println(Arrays.toString(ans));
    }


    //Optimal approach, T.C: O(n) for best&avg case, worst case: O(n^2), S.C:O(n)
    static int[] SumOptimal(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];

            if (map.containsKey(need)) {
                return new int[]{map.get(need),i};
            }

            map.put(arr[i], i); // store element with its index
        }

        return new int[]{-1,-1};
    }

//T.C: O(n^2), S.C:O(1)
    static int[] ReturnIndexSum(int[] arr, int target) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
