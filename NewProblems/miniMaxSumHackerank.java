import java.util.List;

public class miniMaxSumHackerank {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            total += num;

            if (num < min)
                min = num;

            if (num > max)
                max = num;
        }

        long minSum = total - max;
        long maxSum = total - min;

        System.out.println(minSum + " " + maxSum);
    }
}
