public class PaintersPartition {
    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int k = 2;

        int ans = findMinTime(boards, k);
        System.out.println("Minimum time: " + ans);
    }

    static int findMinTime(int[] boards, int k) {
        int low = getMax(boards);
        int high = getSum(boards);

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPaint(boards, k, mid)) {
                ans = mid;
                high = mid - 1; // try smaller time
            } else {
                low = mid + 1; // increase time
            }
        }
        return ans;
    }

    static boolean canPaint(int[] boards, int k, int maxTime) {
        int painters = 1;
        int currTime = 0;

        for (int board : boards) {
            if (currTime + board <= maxTime) {
                currTime += board;
            } else {
                painters++;
                currTime = board;

                if (painters > k) return false;
            }
        }
        return true;
    }

    static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) max = Math.max(max, num);
        return max;
    }

    static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }
}