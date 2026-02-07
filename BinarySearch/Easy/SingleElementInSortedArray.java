public class SingleElementInSortedArray {
    public static void main(String[] args) {
       int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
       int n = findSingleElementOptimal(arr);
        System.out.println("Single element: "+n);
    }

    //T.C: O(logback2 n), S.C:O(1)
    static int findSingleElementOptimal(int[] arr) {
        int n = arr.length;

        // Edge case: if the first element is unique
        if (arr[0] != arr[1])
            return arr[0];

        // Edge case: if the last element is unique
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        // Binary search boundaries (excluding already checked edges)
        int low = 1, high = n - 2;

        while (low <= high) {
            // Standard mid calculation to avoid overflow
            int mid = low + (high - low) / 2;

            // If mid element is not equal to its neighbors,
            // then it is the single (unique) element
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            /*
             * Observation:
             * - Before the single element, pairs start at even indices
             * - After the single element, pairs start at odd indices
             *
             * If:
             * 1) mid is odd and arr[mid] == arr[mid - 1], OR
             * 2) mid is even and arr[mid] == arr[mid + 1]
             * → single element lies on the RIGHT side
             */
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                    (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            }
            // Otherwise, the single element lies on the LEFT side
            else {
                high = mid - 1;
            }
        }

        // Should never reach here for a valid input
        return -1;
    }


    //T.C: O(logback2 n), S.C:O(1)
    /*static int findSingleElementOptimal(int[] arr){
        int n = arr.length;
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n-1] != arr[n-2]) return arr[n-1];

        int low = 1, high = n-2;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
                return arr[mid];
            }

            if (mid % 2 == 1 && arr[mid] == arr[mid-1] || mid % 2 == 0  && arr[mid] == arr[mid+1]){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
*/
    //T.C:O(n), S.C:O(1)
    static int FindSingleElement(int[] arr){
        int n = arr.length;
        if (n == 1){
            return arr[0];
        }

        for (int i = 0; i < n; i++){
            if (i == 0){
                if (arr[i] != arr[i+1]) return arr[i];
            }else if (i == n-1){
                if (arr[i] != arr[i-1]) return arr[i];
            }else{
                if (arr[i] != arr[i+1] && arr[i] != arr[i-1]){
                    return arr[i];
                }
            }
        }
        return -1;
    }
}
