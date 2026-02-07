public class NumberOfTimesArrayRotated {
    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int n = NumberOfRotations(arr);
        System.out.println("Number of rotations: "+n);
    }

    //T.C: O(logback2 n), S.C:O(1)
    static int NumberOfRotations(int[] arr){
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            //if search space is already sorted, then always arr[low] is will be smaller in that case.
            if(arr[low] <= arr[high]){
                if (arr[low] < ans){
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            // left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans){
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            }
            // right half is sorted
            else {
                if (arr[mid] < ans){
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }


}
