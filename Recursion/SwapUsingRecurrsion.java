import java.util.Arrays;
import java.util.Scanner;

public class SwapUsingRecurrsion {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter size of array: ");
//        int n = sc.nextInt();
//
//        int[] arr = new int[n];
//
//        System.out.println("Enter " + n + " elements:");
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        swap2(arr, 0);
//
//        System.out.println("Reversed Array: " + Arrays.toString(arr));
////////////////////////////////////////////////////////////////////////////////////////////////

        int[] arr = {1, 2, 3, 4, 5};
//        int l = 0;
//        int r = arr.length - 1;
//        Swap(arr, l, r);

        swap2(arr,0);
        System.out.println(Arrays.toString(arr));
    }


    static int[] Swap(int[] arr, int l, int r) {

        // base condition: stop when pointers cross or meet
        if (l >= r) return arr;

        //swap
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        return Swap(arr, l + 1, r - 1);
    }


    static int[] swap2(int[] arr, int i) {
        int n = arr.length;

        if (i >= n / 2) {
            return arr;
        }

        // swap
        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;

        return swap2(arr, i + 1); // move forward
    }
}
