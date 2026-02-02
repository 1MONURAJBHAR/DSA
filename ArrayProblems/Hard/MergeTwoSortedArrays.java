import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        long[] arr1 = {1,3,5,7};
        long[] arr2 = {0,2,6,8,9};
        mergeOptimal(arr1, arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1)+" "+Arrays.toString(arr2));
    }

    /*Using the gap method, we repeatedly compare elements that are gap distance apart and swap them if they are out of order.
     This gradually moves larger elements from the left array to the right and smaller elements from the right array to the left — without using extra space.*/
    /*Why we need multiple passes (gap reduction)
    One swap doesn’t fully sort the arrays.
    So we:
    Start with a large gap → move elements closer to correct region
    Reduce gap → refine order
    Gap = 1 → final sorted order
    This is why it’s inspired by Shell Sort.

    “The gap method works by swapping out-of-order elements across both arrays, ensuring that all smaller elements move left and larger elements move right, achieving an in-place merge.”
    */


    //T.C: O((n + m) * log₂(n + m)), S.C: O(1)
    static void mergeOptimal(long[] arr1, long[] arr2, int n, int m) {

        int gap = (n + m + 1) / 2;

        while (gap > 0) {

            int left = 0;
            int right = left + gap;

            while (right < n + m) {

                // left in arr1, right in arr1
                if (left < n && right < n) {
                    if (arr1[left] > arr1[right]) {
                        swap(arr1, left, arr1, right);
                    }
                }

                // left in arr1, right in arr2
                else if (left < n && right >= n) {
                    if (arr1[left] > arr2[right - n]) {
                        swap(arr1, left, arr2, right - n);
                    }
                }

                    // left in arr2, right in arr2
                else {
                    if (arr2[left - n] > arr2[right - n]) {
                        swap(arr2, left - n, arr2, right - n);
                    }
                }

                left++;
                right++;
            }

            if (gap == 1) break;
            gap = (gap + 1) / 2;
        }
    }

    static void swap(long[] a, int i, long[] b, int j) {
        long temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }




















    //T.C: O(min(n,m))+O(n log(n))+O(m log(m)) , S.C:O(1)
    static void merge2(int[] arr1, int[] arr2, int n, int m){
        int left = n-1;
        int right = 0;

        while(left >= 0 && right < m){
            if (arr1[left] > arr2[right]){

                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;

                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }


    //T.C:O(n+m)+O(n+m), S.C:O(n+m)
    static void merge(int[] arr1, int[] arr2, int n, int m){
        int[] ans = new int[n+m];

        int left = 0;
        int right = 0;
        int index = 0;

        while(left < n && right < m){
            if (arr1[left] <= arr2[right]){
                ans[index] = arr1[left];
                left++;
                index++;
            }else{
                ans[index] = arr2[right];
                right++;
                index++;
            }
        }

        while(left < n){
            ans[index++] = arr1[left++];
        }

        while(right < m){
            ans[index++] = arr2[right++];
        }

        for (int i = 0; i < n+m; i++){
            if (i < n) arr1[i] = ans[i];
            else arr2[i-n] = ans[i];
        }
    }
}
