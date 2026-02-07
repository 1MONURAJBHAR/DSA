public class SortInRotatedSortedArrayDuplicates {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        boolean ans = Search(arr,2);
        System.out.println(ans);
    }

    //T.C:O(logback2 n) best & avg case, O(n/2) worst case for trimming down, if array contains--> [3,3,3,3,3,3,3,3,3]
    static boolean Search(int[] arr, int target){
        int n = arr.length;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] == target){
                return true;
            }

            //trim the array for duplicates
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

            if (arr[low] < arr[mid]){
                if (arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                }else{
                    low  = mid + 1;
                }
            }else {
                if (arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
