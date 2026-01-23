import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {
    //two dimensional array
    public static void main(String[] args) {
        //int[][] arr = new int[3][];   //adding the no. of rows is compulsory. columns is optional
       // int[][] arr = new int[3][3];

        //syntax 2
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//        };

        //        int[][] arr2 = {
//                {1, 2, 3},  //0th index
//                {4, 5},    //1st index
//                {7, 8, 5, 9},  //2nd index
//        };

        Scanner sc = new Scanner(System.in);
        //columns can vary
        int[][] arr  = new int[3][3];
        System.out.println(arr.length);

        //take input
        for (int row = 0; row < arr.length; row++){  //outer for loop is iterating every row
           for (int col = 0; col < arr[row].length; col++){  //inner for loop is iterating every column
               arr[row][col] = sc.nextInt();
           }
        }

//        for (int row = 0; row < arr.length; row++){  //outer for loop is iterating every row
//            for (int col = 0; col < arr[row].length; col++){  //inner for loop is iterating every column
//                System.out.print(arr[row][col] + " ");
//            }
//            System.out.println();
//        }

//       for (int row = 0; row<arr.length; row++){
//           System.out.println(Arrays.toString(arr[row]));  //print each row inside the array
//       }

       //Enhanced for loop
        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }

    }
}
