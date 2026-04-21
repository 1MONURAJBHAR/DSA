import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        int[] arr = {0, 3, 4, 7, 9, 10};
        int cows = 4;

        int ans = findMinDistWhichIsMax(arr, cows);
        System.out.println("Minimum distance which is maximum between cows is: " + ans);
    }

    // Linear Search (fixed)
    static int findMinDistWhichIsMax(int[] arr, int cows){
        Arrays.sort(arr);

        int max = arr[arr.length - 1] - arr[0];
        int ans = 0;

        for (int i = 1; i <= max; i++){
            if (canPlaceCows(arr, i, cows)){
                ans = i;   // update answer
            } else {
                break;     // no need to continue
            }
        }
        return ans;
    }

    //Binary search
    static int maxDistanceBS(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, cows, mid)) {
                ans = mid;        // valid distance
                low = mid + 1;    // try larger
            } else {
                high = mid - 1;   // reduce distance
            }
        }

        return ans;
    }


    static boolean canPlaceCows(int[] arr, int dist, int cows){
        int countCows = 1;
        int lastPos = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (arr[i] - lastPos >= dist){
                countCows++;
                lastPos = arr[i];
            }
        }

        return countCows >= cows;
    }

   /* static boolean canPlaceCows(int[] stalls, int cows, int dist) {
        int count = 1; // first cow at first stall
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
            }

            if (count >= cows) return true;
        }

        return false;
    }*/
}