
public class UpperBound {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,8,8,10,10,11};
        int n = upperbound(arr,2);
        System.out.println("index: "+0);
    }

    //smallest index such that "arr[index] > target",   T.C: O(logback2 n)
    static int upperbound(int[] arr, int target){
        int n = arr.length;

        int low = 0, high = n-1;
        int ans = n; //default n

        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] > target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

}

