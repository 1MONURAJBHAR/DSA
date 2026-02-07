public class NumberOfTimesArrayRotatedDuplicates {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3,3,3,3,4,5,1,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
        int n = NumberOfRotations(arr);
        System.out.println("Number of rotations: "+n);
    }


    // Average: O(log n), Worst (duplicates): O(n)
    // Space: O(1)
    static int NumberOfRotations(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // handle duplicates
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low++;
                high--;
                continue;
            }

            // already sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                break;
            }

            // left half sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            // right half sorted
            else {
                if (arr[mid] < ans) {
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
