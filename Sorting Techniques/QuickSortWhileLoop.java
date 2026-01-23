import java.util.Arrays;

public class QuickSortWhileLoop {

    public static void main(String[] args) {
        // Input array to be sorted
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};

        // Call QuickSort on full array range
        quickSort(arr, 0, arr.length - 1);

        // Print sorted array
        System.out.println(Arrays.toString(arr));
    }

    /**
     * QuickSort function (recursive)
     * Sorts the array between indexes low and high (inclusive).
     */
    public static void quickSort(int[] arr, int low, int high) {
        // Base condition: if there are at least 2 elements
        if (low < high) {

            // Partition the array and get pivot's correct index
            int pIndex = partition(arr, low, high);

            // Recursively sort elements on left side of pivot
            quickSort(arr, low, pIndex - 1);

            // Recursively sort elements on right side of pivot
            quickSort(arr, pIndex + 1, high);
        }
    }

    /**
     * Partition function (Hoare-style partition with pivot = first element)
     * It places pivot at its correct position such that:
     * - all elements <= pivot are on the left side
     * - all elements > pivot are on the right side
     *
     * Returns the final index of pivot.
     */
    private static int partition(int[] arr, int low, int high) {

        // Choose first element as pivot
        int pivot = arr[low];

        // i starts from low and moves right
        int i = low;

        // j starts from high and moves left
        int j = high;

        // Keep swapping until both pointers cross
        while (i < j) {

            // Move i forward until we find an element greater than pivot
            // (because elements <= pivot should stay on left side)
            while (i <= high-1 && arr[i] <= pivot) {
                i++;
            }

            // Move j backward until we find an element less than or equal to pivot
            // (because elements > pivot should stay on right side)
            while (j >= low+1 && arr[j] > pivot) {
                j--;
            }

            // If i is still left of j, swap wrong-position elements
            // arr[i] is > pivot (wrong on left)
            // arr[j] is <= pivot (wrong on right)
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Finally, place pivot in its correct sorted position
        // j is the final position where pivot should go
        swap(arr, low, j);

        // Return pivot index
        return j;
    }

    /**
     * Utility function to swap two elements in the array.
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
