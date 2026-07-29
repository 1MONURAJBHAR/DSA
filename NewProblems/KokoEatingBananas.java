public class KokoEatingBananas {

    /**
     * Finds the minimum eating speed (bananas/hour) required for Koko
     * to finish all banana piles within the given number of hours.
     *
     * Uses Binary Search on the answer:
     * - Minimum possible speed = 1 banana/hour.
     * - Maximum possible speed = largest pile size.
     *
     * Time Complexity: O(n * log(maxPile))
     * Space Complexity: O(1)
     */
    public static int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = getMax(piles);

        // Binary Search on possible eating speeds
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If Koko can finish all bananas at this speed,
            // try to find a smaller valid speed.
            if (canFinish(piles, mid, h)) {
                high = mid - 1;
            }
            // Otherwise, increase the eating speed.
            else {
                low = mid + 1;
            }
        }

        // 'low' will be the minimum valid eating speed.
        return low;
    }

    /**
     * Checks whether Koko can finish all banana piles
     * at the given eating speed within 'h' hours.
     *
     * For each pile:
     * Hours required = ceil(pile / speed)
     */
    public static boolean canFinish(int[] piles, int k, int h) {

        int totalHours = 0;

        for (int pile : piles) {

            // Ceiling division:
            // Example:
            // pile = 7, speed = 3
            // Hours = ceil(7 / 3) = 3
            //totalHours += Math.ceil((double) pile / k);  // or
            totalHours += (pile + k - 1) / k;
        }

        // Return true if all piles can be finished within h hours.
        return totalHours <= h;
    }

    /**
     * Returns the largest pile size.
     * This represents the maximum possible eating speed.
     */
    public static int getMax(int[] piles) {

        int max = Integer.MIN_VALUE;

        for (int num : piles) {
            max = Math.max(max, num);
        }

        return max;
    }
}