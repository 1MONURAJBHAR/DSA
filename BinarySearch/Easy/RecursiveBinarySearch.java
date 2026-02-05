public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int ans = binarySearch(arr,3,0,arr.length-1);
        System.out.println(ans);
    }

    //Recursive binary search, T.C: O(logback2 n)
    static int binarySearch(int[] arr, int target, int low, int high) {

        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target){
            return mid;
        }else if (arr[mid] > target){
           return binarySearch(arr, target, low, mid-1);
        }else{
           return binarySearch(arr, target, mid+1, high);
        }
    }
}