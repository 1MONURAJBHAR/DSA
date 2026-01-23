import java.util.LinkedHashSet;
import java.util.Set;

/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.*/

public class RemoveDuplicatesUsingLinkedHashSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};

       /* int[] ans = removeDuplicates(arr);

        for (int x : ans) {
            System.out.print(x + " ");
        }*/

        int ans = removeDuplicates2(arr);
        System.out.println("Size of unique elements: "+ans);
    }

    //T.C --> O(n),average, S.C--> O(n),(extra set + result array)
    static int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        // LinkedHashSet maintains insertion order + removes duplicates
        Set<Integer> set = new LinkedHashSet<>();

        for (int x : arr) {
            set.add(x);
        }

        // Create new array of unique size
        int[] result = new int[set.size()];

        int i = 0;
        for (int x : set) {
            result[i++] = x;
        }

        return result;
    }



    //modifies the array and returns the length of unique elements
    //T.C --> O(n)(average), S.C --> O(n) extra space
    static int removeDuplicates2(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        // LinkedHashSet maintains insertion order + removes duplicates
        Set<Integer> set = new LinkedHashSet<>();

        for (int x : arr) {
            set.add(x);
        }

        int index = 0;
        for (int x : set) {
            arr[index++] = x;
        }

        return index;
    }
}
