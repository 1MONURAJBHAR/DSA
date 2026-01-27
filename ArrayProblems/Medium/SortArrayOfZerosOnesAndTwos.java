import java.util.Arrays;

//Dutch National flag algorithm
public class SortArrayOfZerosOnesAndTwos {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
//        int[] ans = SortArray(arr);
//        SortArray2(arr);
        sortArray3(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Dutch National flag algorithm, Optimal one
    //T.C:O(n), S.C:O(1)
    static void sortArray3(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else { // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //better--> T.C:O(2n) , S.C:O(1)
    static void SortArray2(int[] arr){
        int count0 = 0, count1 = 0, count2 = 0;

        // Count 0s, 1s, 2s
        for (int x : arr) {
            if (x == 0) count0++;
            else if (x == 1) count1++;
            else count2++;
        }

        // Put 0s
        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }

        // Put 1s
        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }

        //  Put 2s
        for (int i = count0 + count1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    //brute force
    static int[] SortArray(int[] arr){
        //or use any sorting algorithm like merge sort or quick sort
        Arrays.sort(arr);
        return arr;
    }
}
