import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RotateLeftBy_D_Spaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;

        System.out.println("Enter number of rotations: ");
        int d = sc.nextInt();

//        rotateRight(arr, d);
        rotateLeft(arr, d);

        System.out.println(Arrays.toString(arr));
    }


    //Brute force approach, T.C --> O(n+d) , S.C --> O(d)
    /**
     * Rotates the array to the left by d positions using extra space.
     */
    static void rotateLeft(int[] arr, int d) {
        int n = arr.length;

        // If d is greater than n, reduce it using modulo
        d = d % n;

        if (d == 0) return;

        // Temporary list to store first d elements
        List<Integer> temp = new ArrayList<>();

        // Store first d elements in temp
        for (int i = 0; i < d; i++) {
            temp.add(arr[i]);
        }

        // Shift remaining elements to the left by d positions
        // Example: [1,2,3,4,5], d=2 -> shift [3,4,5] to front
        for (int j = d; j < n; j++) {
            arr[j - d] = arr[j];
        }

        for (int k = n - d; k < n; k++) {
            arr[k] = temp.get(k - (n - d));
        }
    }

    static void rotateRight(int[] arr, int d) {
        int n = arr.length;

        d = d % n;
        if (d == 0) return;

        // Store last d elements
        List<Integer> temp = new ArrayList<>();
        for (int i = n - d; i < n; i++) {
            temp.add(arr[i]);
        }

        // Shift remaining elements to the right by d positions
        for (int j = n - d - 1; j >= 0; j--) {
            arr[j + d] = arr[j];
        }

        // Put temp elements at the beginning
        for (int k = 0; k < d; k++) {
            arr[k] = temp.get(k);
        }
    }

}
