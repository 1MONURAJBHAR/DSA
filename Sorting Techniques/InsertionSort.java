import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 3, 4, 5, 2, 1};
        InsertionSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    //T.C --> best case: O(n), worst&avg case: O(n^2)
    static void InsertionSort1(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;

            // Move current element left until it's in correct position
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--; // move left
            }
        }
    }

    //shifting version
    static void InsertionSort2(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

}
