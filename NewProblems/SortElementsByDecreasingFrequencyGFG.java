import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SortElementsByDecreasingFrequencyGFG {
    public static ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here

       /*Approach:
        Count the frequency of each element using a HashMap.
        Convert the array to an Integer[] (because Arrays.sort() with a comparator doesn't work on primitive int[]).
        Sort using a custom comparator:
        Higher frequency first.
        If frequencies are equal, smaller number first.
        Convert back to ArrayList<Integer>.*/

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert int[] to Integer[]
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        // Sort
        Arrays.sort(nums, (a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);   // Higher frequency first
            }
            return a - b;                         // Smaller number first
        });

        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);
        }

        return ans;
    }
}
