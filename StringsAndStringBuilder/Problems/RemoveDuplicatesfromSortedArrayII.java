import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {

    public static int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2; // First two elements are always allowed

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("Length after removing duplicates: " + k);

        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}