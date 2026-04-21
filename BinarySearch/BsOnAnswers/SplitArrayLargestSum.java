public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        int ans = splitArray(nums, k);
        System.out.println("Minimum largest sum: " + ans);
    }

    static int splitArray(int[] nums, int k) {
        int low = getMax(nums);
        int high = getSum(nums);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currSum = 0;

        for (int num : nums) {
            if (currSum + num <= maxSum) {
                currSum += num;
            } else {
                count++;
                currSum = num;

                if (count > k) return false;
            }
        }
        return true;
    }

    static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) max = Math.max(max, num);
        return max;
    }

    static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }
}