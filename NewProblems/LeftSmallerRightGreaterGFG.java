public class LeftSmallerRightGreaterGFG {

    // Function to find the first element such that
    // all elements on its left are <= it
    // and all elements on its right are >= it.
    public static int findElement(int[] arr) {

        int n = arr.length;

        // Stores maximum element from left up to index i
        int[] leftMax = new int[n];

        // Stores minimum element from right up to index i
        int[] rightMin = new int[n];

        // Build leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Build rightMin array
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        // Check every middle element
        for (int i = 1; i < n - 1; i++) {

            // Largest element on the left <= current element
            // Smallest element on the right >= current element
            if (leftMax[i - 1] <= arr[i] &&
                    arr[i] <= rightMin[i + 1]) {

                return arr[i];
            }
        }

        // No such element exists
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 7};

        int ans = findElement(arr);

        System.out.println("Answer: " + ans);
    }
}