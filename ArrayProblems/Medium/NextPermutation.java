import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0, 0};
//        nextPermutationForLoop(arr);
        nextPermutationWhileLoop(arr);
        System.out.println(Arrays.toString(arr));
    }

    //T.C: O(3n), S.C:O(1) or if consider the existing array usage then O(n).
    static void nextPermutationWhileLoop(int[] num1) {
        int n = num1.length;
        int i = n - 2;

        // find breakpoint
        while (i >= 0 && num1[i] >= num1[i + 1]) {
            i--;
        }

        // find element just larger than num1[i]
        if (i >= 0) {
            int j = n - 1;
            while (j > i && num1[j] <= num1[i]) {
                j--;
            }
            swap(num1, i, j);
        }

        // reverse suffix
        reverse(num1, i + 1, n - 1);
    }


    static void nextPermutationForLoop(int[] nums) {
        int n = nums.length;
        int ind = -1;

            //  Find the breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

            //  If no breakpoint, reverse whole array
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

            //  Find next greater element and swap
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

            //  Reverse the suffix
        reverse(nums, ind + 1, n - 1);
    }


    static void swap(int[] num1, int i, int j) {
        int temp = num1[i];
        num1[i] = num1[j];
        num1[j] = temp;
    }

    static void reverse(int[] num1, int left, int right) {
        while (left < right) {
            swap(num1, left++, right--);
        }
    }
}
