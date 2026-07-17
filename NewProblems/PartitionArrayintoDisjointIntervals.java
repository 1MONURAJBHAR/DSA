public class PartitionArrayintoDisjointIntervals {
    // Function to find the length of the left partition
    public static int partitionDisjoint(int[] nums) {

        int n = nums.length;

        // prefixMax[i] = Maximum element from index 0 to i
        int[] prefixMax = new int[n];

        // suffixMin[i] = Minimum element from index i to n-1
        int[] suffixMin = new int[n];

        // Build prefixMax array
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        // Build suffixMin array
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        // Find the first valid partition
        for (int i = 0; i < n - 1; i++) {

            // If every element in left <= every element in right
            if (prefixMax[i] <= suffixMin[i + 1]) {
                return i + 1; // Length of left partition
            }
        }

        // Problem guarantees an answer, so this won't be reached
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {5, 0, 3, 8, 6};

        int ans = partitionDisjoint(nums);

        System.out.println("Length of Left Partition: " + ans);
    }
}
