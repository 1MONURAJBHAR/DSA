import java.util.*;

public class MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        // Stores the frequency of each number in arr
        Map<Integer, Integer> freqArr = new HashMap<>();

        // Stores the frequency of each number in brr (original array)
        Map<Integer, Integer> freqBrr = new HashMap<>();


        // Count the frequency of each element in arr
        for (int num : arr) {
            // If num is not present, start with 0, then increment by 1
            freqArr.put(num, freqArr.getOrDefault(num, 0) + 1);
        }


        // Count the frequency of each element in brr
        for (int num : brr) {
            // If num is not present, start with 0, then increment by 1
            freqBrr.put(num, freqBrr.getOrDefault(num, 0) + 1);
        }


        // List to store the missing numbers
        List<Integer> ans = new ArrayList<>();


        // Traverse all unique numbers present in brr
        for (int num : freqBrr.keySet()) {   //Accessing only the keys of freqBrr map

            // Compare the frequency of the current number
            // If frequency in arr is smaller, then the number is missing
            if (freqArr.getOrDefault(num, 0) < freqBrr.getOrDefault(num, 0)) {
                ans.add(num);
            }
        }


        // Sort the missing numbers in ascending order
        Collections.sort(ans);

        // Return the final sorted list
        return ans;
    }
}