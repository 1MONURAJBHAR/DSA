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


    /*The idea is:
    Build only the rightMin[] array.
    While traversing from left to right, maintain leftMax as a single variable.

    Algorithm:
    Create rightMin[].
    Fill it from right to left.
    Initialize leftMax = arr[0].
    Traverse from i = 1 to n - 2:
    If leftMax <= arr[i] and arr[i] <= rightMin[i + 1], return arr[i].
    Update leftMax = max(leftMax, arr[i]).*/

    public static int findElement2(int[] arr) {

        int n = arr.length;

        // Store minimum element from the right
        int[] rightMin = new int[n];

        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        // Maximum element seen so far from the left
        int leftMax = arr[0];

        for (int i = 1; i < n - 1; i++) {

            if (leftMax <= arr[i] &&
                    arr[i] <= rightMin[i + 1]) {
                return arr[i];
            }

            leftMax = Math.max(leftMax, arr[i]);
        }

        return -1;
    }



    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 7};

        int ans = findElement(arr);

        System.out.println("Answer: " + ans);
    }
}