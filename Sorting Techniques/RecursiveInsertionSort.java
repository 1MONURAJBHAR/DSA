import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 3, 4, 5, 2, 1};
        InsertionSort(arr,8);
        System.out.println(Arrays.toString(arr));

        //2nd approach, not required but still!!!
        /*int[] arr = {5, 2, 9, 1, 3};
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));*/
    }

    static void InsertionSort(int[] arr,int n){
        if (n == 1) return;

        InsertionSort(arr,n-1);

        int last = arr[n-1];
        int j = n-2;

        while(j>=0 && arr[j] > last){
            arr[j+1] = arr[j];
            j--;
        }
        //After shifting bigger elements, arr[j+1] = last; inserts last into the correct sorted position.
        arr[j + 1] = last;
    }

    //2nd approach, not required but still!!!
    /* static void insertionSort(int[] arr, int n) {
        if (n <= 1) return;

        // Sort first n-1 elements
        insertionSort(arr, n - 1);

        // Insert last element into sorted part using recursion
        int last = arr[n - 1];
        insert(arr, n - 2, last);
    }

    static void insert(int[] arr, int i, int key) {
        // If reached start OR correct position found
        if (i < 0 || arr[i] <= key) {
            arr[i + 1] = key;
            return;
        }

        // Shift element to right
        arr[i + 1] = arr[i];

        // Recursive call for previous index
        insert(arr, i - 1, key);
    }*/
}
