public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
       int[] arr = {7,8,9,0,2,3,4,5,6};
       int ans = findMinimum(arr);
        System.out.println(ans);
    }

    //T.C: O(logback2 n), S.C:O(1)
    static int findMinimum(int[] arr){
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            //if search space is already sorted, then always arr[low] is will be smaller in that case.
            if(arr[low] <= arr[high]){
                ans = Math.min(ans, arr[low]);
                break;
            }

            // left half is sorted
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }
            // right half is sorted
            else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }


}
