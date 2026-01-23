import java.util.Arrays;

public class RecursiveBubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    //T.C --> O(n)
    public static void bubbleSort(int[] arr, int n) {
        // Base case: size 0 or 1 is already sorted
        if (n == 1) return;

        // One pass: push largest element to end
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursively sort remaining part
        bubbleSort(arr, n - 1);
    }
}
