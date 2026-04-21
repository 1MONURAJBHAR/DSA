import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};

        double ans = findMedian2(arr1, arr2);
        System.out.println(ans);
    }

    //brute force approach
    static double findMedian(int[] num1, int[] num2) {

        int n1 = num1.length;
        int n2 = num2.length;
        int n = n1 + n2;

        List<Integer> arr = new ArrayList<>();

        int i = 0, j = 0;

        // Merge
        while (i < n1 && j < n2) {
            if (num1[i] < num2[j]) {
                arr.add(num1[i++]);
            } else {
                arr.add(num2[j++]);
            }
        }

        // Remaining elements
        while (i < n1) arr.add(num1[i++]);
        while (j < n2) arr.add(num2[j++]);

        // Median
        if (n % 2 == 1) {
            return arr.get(n / 2);
        } else {
            return (arr.get(n / 2) + arr.get((n / 2) - 1)) / 2.0;
        }
    }

    //Better approach
    static double findMedian2(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int idx1 = (n / 2) - 1;
        int idx2 = n / 2;

        int i = 0, j = 0, k = 0;
        int ele1 = -1, ele2 = -1;

        // Merge till median positions
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (k == idx1) ele1 = nums1[i];
                if (k == idx2) ele2 = nums1[i];
                i++;
            } else {
                if (k == idx1) ele1 = nums2[j];
                if (k == idx2) ele2 = nums2[j];
                j++;
            }
            k++;
        }

        // Remaining elements
        while (i < n1) {
            if (k == idx1) ele1 = nums1[i];
            if (k == idx2) ele2 = nums1[i];
            i++;
            k++;
        }

        while (j < n2) {
            if (k == idx1) ele1 = nums2[j];
            if (k == idx2) ele2 = nums2[j];
            j++;
            k++;
        }

        // Median calculation
        if (n % 2 == 1) {
            return ele2;
        }

        return (ele1 + ele2) / 2.0;
    }




























}