public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int ans = binarySearch(arr,3);
        System.out.println(ans);
    }

   //iterative approach, T.C: O(logback2 n)
    static int binarySearch(int[] arr, int target){
        int n = arr.length;

        int low = 0, high = n-1;

        while(low <= high){
            int mid = low+(high-low)/2;

            if(arr[mid] < target){
                low = mid+1;
            }else if(arr[mid] > target){
                high = mid-1;
            }else{
               return mid;
            }
        }
        return -1;
    }
}
