import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] arr, int cows){
        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(arr, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean canPlace(int[] arr, int k, int dist) {
        int cows = 1;
        int lastPos = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPos >= dist) {
                cows++;
                lastPos = arr[i];

                if (cows == k) {
                    return true;
                }
            }
        }

        return false;
    }
}
