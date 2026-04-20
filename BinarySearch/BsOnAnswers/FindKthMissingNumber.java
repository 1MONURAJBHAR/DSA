public class FindKthMissingNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int ans = findKthNumberBS(arr, k);
        System.out.println(ans);
    }

    //linear approach
    static int findKthNumber(int[] nums, int k){

        for (int num : nums){
            if (num <= k) {
                k++;
            }else {
                break;
            }
        }

        return k;
    }

    //binary search
    static int findKthNumberBS(int[] nums, int k){
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int missing = nums[mid] - (mid + 1);

            if (missing < k){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low + k;
    }

}
