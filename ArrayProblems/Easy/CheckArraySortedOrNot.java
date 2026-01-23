public class CheckArraySortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
//        boolean ans = CheckSorted(arr);
        boolean ans = isSorted(arr, arr.length);
        System.out.println("Is sorted: "+ans);
    }

    //T.C --> O(n)
    static boolean CheckSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false; // not sorted
            }
        }
        return true; // sorted
    }

    // Function to check if the array is sorted
    static boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])  // If any element is smaller than the previous one, return false
                return false;
        }
        return true;  // Return true if the array is sorted
    }

    //for sorted rotated array-->[3,4,5,1,2]
    /*In a sorted rotated array, there can be at most 1 drop where: arr[i] < arr[i-1]
     Also last element should not break rotation rule: arr[0] < arr[n-1] counts as a drop too.*/
   /*[3,4,5,1,2] Drops:
    1 < 5 → 1 drop
    circular check: 3 < 2  no drop
    Total = 1 →  true*/
    static boolean checkSorted(int[] arr) {
        int n = arr.length;
        int countDrops = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                countDrops++;
            }
        }

        // Check the circular condition (last -> first)
        if (arr[0] < arr[n - 1]) {
            countDrops++;
        }

        return countDrops <= 1;
    }

}
