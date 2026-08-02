public class KthMissingPositiveNumber {
    public static int kthMissing(int[] arr, int k){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }

    public static int kthMissing2(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low + k;  //or return high + 1 + k
    }
}
