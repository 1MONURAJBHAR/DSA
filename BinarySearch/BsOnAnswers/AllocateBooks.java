public class AllocateBooks {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int students = 2;

        int ans = maxAllocate(arr, students);
        System.out.println(ans); // Expected: 113
    }

    static int maxAllocate(int[] arr, int students) {
        int n = arr.length;

        if (students > n) return -1;

        int low = getMax(arr);   // FIXED
        int high = getSum(arr);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int requiredStudents = studentCount(arr, mid);

            if (requiredStudents > students) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static int studentCount(int[] nums, int maxPages) {
        int students = 1;
        int pages = 0;

        for (int num : nums) {
            if (pages + num > maxPages) {  // FIXED
                students++;
                pages = num;
            } else {
                pages += num;
            }
        }
        return students;
    }

    static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    static int getSum(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}