import java.util.Arrays;
import java.util.Scanner;

public class InputArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
//        arr[0] = 23;
//        arr[1] = 24;
//        arr[2] = 45;
//        arr[3] = 54;
//        arr[4] = 55;
       //will create array like this --> [23, 24, 45, 54, 55]
        //System.out.println(arr[3]);

        //input using for loop;
        for(int i = 0; i<arr.length; i++){
           arr[i] = sc.nextInt();
        }

        //output using enhanced for loop
//        for (int j : arr) {  //for every element in the array print the array
//            System.out.print(j + " ");  //j represents the element of the array
//        }

        //another method to print
        System.out.println(Arrays.toString(arr));

    }
}
