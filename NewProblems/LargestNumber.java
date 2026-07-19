import java.util.Arrays;

public class LargestNumber {
    public static String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        // Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Handle case like [0,0]
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the answer
        StringBuilder ans = new StringBuilder();
        for (String s : arr) {
            ans.append(s);
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 2};
        System.out.println(largestNumber(nums1));   // 210

        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums2));   // 9534330

        int[] nums3 = {0, 0};
        System.out.println(largestNumber(nums3));   // 0

        int[] nums4 = {432, 43243};
        System.out.println(largestNumber(nums4));   // 43243432
    }
}
