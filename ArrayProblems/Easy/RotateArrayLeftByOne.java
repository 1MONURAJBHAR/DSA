import java.util.Arrays;

public class RotateArrayLeftByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        RotateArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    //T.C --> O(n), S.C-->no extra space:O(1), but using existing arr array hence, S.C while solving problem is O(n).
    static void RotateArray(int[] arr){
        int n = arr.length;
        int temp = arr[0];
        for (int i = 1; i < n; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }
}
