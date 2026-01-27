import java.util.Arrays;

public class DutchNationalFlagAlgorithm {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
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

}
