import java.util.Arrays;
import java.util.Scanner;

public class RotateLeftBy_D_SpacesOptimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;

        System.out.println("Enter number of rotations: ");
        int d = sc.nextInt();

        d = d % n;
        if (d == 0) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        /*Reverse first d elements
          Reverse remaining n-d elements
          Reverse whole array
          This produces Left Rotate*/

         //Rotate array to left
        /*reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
        */

        /*Reverse whole array
          Reverse first k elements
          Reverse remaining elements
          This produces Right Rotate*/
        //Rotate array to right
        reverse(arr,0,n-1);
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);



        System.out.println(Arrays.toString(arr));
    }

    //Optimal approach, T.C --> O(2n), S.C--> O(1), no extra space taken, using only existing array, hence space used to solve the problem is O(n)
    static void reverse(int[] arr, int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
