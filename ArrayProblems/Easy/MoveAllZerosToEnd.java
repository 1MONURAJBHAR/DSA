import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        MoveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Brute force: T.C-->O(2n) == O(n), S.C-->O(n)
    static void MoveZeros(int[] arr){
        List<Integer> temp = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++){
            if (arr[i] != 0){
                temp.add(arr[i]);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }

        for (int i = temp.size(); i < n; i++){
            arr[i] = 0;
        }

        //OR instead of two loops
        /*for (int i = 0; i < n; i++){
            if (i<temp.size()){
                arr[i] = temp.get(i);
            }else{
                arr[i] = 0;
            }
        }*/

    }
}
