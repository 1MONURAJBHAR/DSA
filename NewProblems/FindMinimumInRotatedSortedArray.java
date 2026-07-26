public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] arr) {

        // Initialize search space
        int low = 0;
        int high = arr.length - 1;

        // Stores the minimum element found so far
        int ans = Integer.MAX_VALUE;

        // Perform Binary Search
        while (low <= high) {

            // Calculate middle index
            int mid = low + (high - low) / 2;

            // If the current search space is already sorted,
            // then arr[low] is the minimum in this range.
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            // Check if the left half is sorted
            if (arr[low] <= arr[mid]) {

                // Since the left half is sorted,
                // the smallest element in this half is arr[low].
                ans = Math.min(ans, arr[low]);

                // Search in the right half
                low = mid + 1;
            } else {

                // Right half is sorted, so the pivot (minimum)
                // lies in the left half including mid.
                ans = Math.min(ans, arr[mid]);

                // Search in the left half
                high = mid - 1;
            }
        }

        // Return the minimum element found
        return ans;
    }
}
