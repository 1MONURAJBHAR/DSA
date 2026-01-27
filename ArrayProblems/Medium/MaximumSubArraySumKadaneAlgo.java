import java.util.Arrays;

public class MaximumSubArraySumKadaneAlgo {
    public static void main(String[] args) {
       int[] arr = {-2,-3,4,-1,-2,1,5,-3};
       /* int ans =  MaxSubArray3(arr);
        System.out.println(ans);*/

//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArray(arr);
        System.out.println(Arrays.toString(result));
    }

    //canonical Kadane implementation.This is the canonical Kadane’s algorithm with start and end index tracking, running in O(n) time and O(1) extra space.
    static int[] maxSubArrayWithElements(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        // extract subarray
        int[] subArray = new int[ansEnd - ansStart + 1];
        for (int i = ansStart, k = 0; i <= ansEnd; i++, k++) {
            subArray[k] = arr[i];
        }

        return subArray;
    }


    //Kadane's Algo, T.C:O(n), S.C:O(1), returning subArray.
    static int[] maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            if (sum == 0) {
                start = i;
            }

            sum += arr[i];

            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        //Both have the same time and space complexity; Arrays.copyOfRange is cleaner, while the manual loop gives more control and is preferred in algorithmic interviews.

        // extract the subArray,(Library Method)
        return Arrays.copyOfRange(arr, ansStart, ansEnd + 1);

        //Manual Copy (Loop)
      /*  int[] subArray = new int[ansEnd - ansStart + 1];
        for (int i = ansStart, k = 0; i <= ansEnd; i++, k++) {
            subArray[k] = arr[i];
        }
        return subArray;*/

        //Java allows multiple variables in the init and update sections: for (init1, init2; condition; update1, update2),So this is perfectly valid Java.

    }


    //Kadane's Algo, T.C:O(n), S.C:O(1)
    //Kadane’s Algorithm finds the maximum sum of a contiguous subArray in linear time by discarding negative prefixes.
    /*If the current subArray sum becomes negative, discard it.
     Why?
     A negative sum will reduce the sum of any future subArray
     So we start fresh from the next element*/
    static int MaxSubArray3(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : arr) {
            sum += num;
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return Math.max(max, 0);  //if max < 0, we will return 0.
    }




    //T.C:O(n^2) S.C:O(1)
    static int MaxSubArray2(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++ ){
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }



    //T.C:O(n^3) S.C:O(1)
    static int MaxSubArray(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++ ){
                int sum = 0;
                for (int k = i; k < j; k++){  //iterating through subArray and taking sum
                    sum += arr[k];
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
}
