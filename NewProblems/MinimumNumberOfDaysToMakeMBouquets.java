public class MinimumNumberOfDaysToMakeMBouquets {

    // Returns the minimum number of days required to make m bouquets,
    // where each bouquet requires k adjacent flowers.
    public static int minDays(int[] bloomDay, int m, int k) {

        // If total flowers are insufficient, it is impossible.
        if (bloomDay.length < (long) m * k) {
            return -1;
        }

        // Search space: minimum bloom day to maximum bloom day.
        int low = findMin(bloomDay);
        int high = findMax(bloomDay);

        // Binary Search on the answer (number of days).
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If bouquets can be made on 'mid' day,
            // try to find a smaller valid day.
            if (PossibleDay(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                // Otherwise, more days are needed.
                low = mid + 1;
            }
        }

        // 'low' stores the minimum valid day.
        return low;
    }

    // Finds the minimum bloom day in the array.
    public static int findMin(int[] bloomDay) {
        int min = Integer.MAX_VALUE;

        for (int num : bloomDay) {
            min = Math.min(min, num);
        }

        return min;
    }

    // Finds the maximum bloom day in the array.
    public static int findMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;

        for (int num : bloomDay) {
            max = Math.max(max, num);
        }

        return max;
    }

    // Checks whether it is possible to make at least 'm' bouquets
    // on the given day.
    public static boolean PossibleDay(int[] bloomDay, int day, int m, int k) {

        int count = 0;      // Counts consecutive bloomed flowers.
        int bouquets = 0;   // Total bouquets formed.

        for (int i = 0; i < bloomDay.length; i++) {

            // Flower has bloomed by 'day'.
            if (bloomDay[i] <= day) {
                count++;
            } else {
                // Consecutive sequence breaks.
                // Form as many bouquets as possible from the current sequence.
                bouquets += count / k;
                count = 0;
            }
        }

        // Process the last consecutive sequence.
        bouquets += count / k;

        // Return true if enough bouquets can be made.
        return bouquets >= m;
    }
}