import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {102,4,100,1,101,3,2,1,1};
        int ans = longestConsecutiveOptimal(arr);
        System.out.println("The longest consecutive sequence is: " + ans);
    }

    //T.C:O(3n), S.C:O(n)
    static int longestConsecutiveOptimal(int[] nums1){
        Set<Integer> set = new HashSet<>();
        int longest = 1;

        for (int x: nums1){
            set.add(x);
        }

           /* Loop through each element in the set to find
           the starting point of consecutive sequences */
        for (int num: nums1){
            // If there is no number before 'num', num’s the start of a sequence
            if(!set.contains(num-1)){
                int count = 1;
                int x = num;
                while(set.contains(x+1)){
                    x = x+1;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }




    //T.C:O(n)+O(n log(n)), S.C:O(1)
    static int longestConsecutive3(int[] nums1){
        if (nums1.length == 0) return 0;

        Arrays.sort(nums1);  //O(n log(n))

        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        for (int num : nums1) {  //O(n)
            if (num - 1 == lastSmaller) {
                cnt++;
                lastSmaller = num;
            } else if (num != lastSmaller) { // handles duplicates
                cnt = 1;
                lastSmaller = num;
            }
            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    //T.C:O(n^2), S.C:O(n)
    static int longestConsecutive(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for (int num: nums){
            set.add(num);
        }

        int longest = 1;

        for (int num : nums) {
            int curr = num;
            int count = 1;

            // keep checking next consecutive numbers
            while (set.contains(curr + 1)) {
                curr = curr + 1;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    //T.C:O(n^2), S.C:O(1)
    static int longestConsecutive2(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;

        for (int num : nums) {
            int curr = num;
            int count = 1;

            // keep checking next consecutive numbers
            while (exists(nums, curr+1)) {
                curr = curr + 1;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    // helper function to check existence,duplicates don’t affect the result
    static boolean exists(int[] arr, int target){
        for (int x: arr){
            if (x == target) return true;
        }
        return false;
    }
}
