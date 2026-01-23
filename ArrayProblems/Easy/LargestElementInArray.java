import java.util.Arrays;
import java.util.Collections;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {5,4,2,7,8,9,1,2};
//        int ans = LargestElement(arr);
        int ans = LargestElement2(arr);
        System.out.println("Largest Element: "+ans);
    }

    //optimized approach: T.C --> O(n)
    static int LargestElement(int[] arr){
        if(arr.length == 0) return 0;

        int max = Integer.MIN_VALUE;
                //OR
//        int max = arr[0];

        for (int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    //Brute force approach: T.C --> O(nlog(n)) "since sorting is used"
    static int LargestElement2(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        return arr[n-1];
    }
}
