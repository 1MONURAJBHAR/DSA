import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveAllZerosToEndOptimal {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        MoveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }




    //Optimal: T.C --> O(n), S.C --> No extra space taken:O(1), but used O(n) (i.e: existing array) to solve the problem
    static void MoveZeros(int[] arr){
        int n = arr.length;

        if(n <= 1) return;

        int j = -1;
        for (int i = 0; i < n; i++){
            if(arr[i] == 0){  //first 0th index
                j = i;
                break;
            }
        }

        // if no zero found, already correct
        if(j == -1) return;

        // move non-zero elements forward
       for (int i = j + 1; i < n; i++){
           if(arr[i] != 0){
               //swap
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               j++;
           }
       }
    }
}
