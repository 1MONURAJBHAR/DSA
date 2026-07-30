public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] arr, int k) {

        if (arr.length > k) return -1;

        // The smallest possible divisor is 1
        int low = 1;

        // The largest possible divisor is the maximum element in the array
        int high = findMax(arr);

        // Binary search for the smallest valid divisor
        while (low <= high) {

            // Calculate the middle divisor
            int mid = low + (high - low) / 2;

            // Check if 'mid' satisfies the threshold condition
            if (computeSum(arr, mid, k)) {

                // Try to find a smaller valid divisor
                high = mid - 1;
            } else {

                // Current divisor is too small, increase it
                low = mid + 1;
            }
        }

        // 'low' points to the smallest valid divisor
        return low;
    }

    // Returns true if the sum of ceil(arr[i] / divisor)
    // is less than or equal to the threshold
    public static boolean computeSum(int[] arr, int divisor, int threshold) {

        int sum = 0;

        // Calculate the required sum using ceiling division
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;
        }

        // Check whether the current divisor satisfies the condition
        return sum <= threshold;
    }

    // Finds and returns the maximum element in the array
    public static int findMax(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            max = Math.max(max, num);
        }

        return max;
    }
}
