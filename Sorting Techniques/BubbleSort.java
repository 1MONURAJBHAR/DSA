import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 3, 4, 5, 2, 1};

        // Calling bubble sort to sort the array in ascending order
       // bubbleSort(arr);
        bubbleSort2(arr);
        // Printing the sorted array
        System.out.println(Arrays.toString(arr));
    }

    //T.C --> O(n^2) -->best & Avg, O(n) -->best.
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop runs for (n - 1) passes
        // After every pass, the largest element moves to the end (correct position)
        for (int i = 0; i < n - 1; i++) {

            // Flag to check if any swapping happened in this pass
            // If no swap happens, it means the array is already sorted
            boolean swapped = false;

            // Inner loop compares adjacent elements and swaps if they are in wrong order
            // We reduce the range by i because last i elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {

                // If current element is greater than next element, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Mark that a swap has occurred
                    swapped = true;
                }
            }

            // If no elements were swapped in this pass, array is already sorted
            // So we can stop early (optimization)
            if (!swapped) {
                break;
            }
        }
    }

    static void bubbleSort2(int[] arr) {
        int n = arr.length;

        // i represents the last index of the unsorted part
        for (int i = n - 1; i >= 1; i--) {

            boolean swapped = false;

            // bubble the largest element to index i
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // if no swaps happened, array is already sorted
            if (!swapped) break;
        }
    }

}
