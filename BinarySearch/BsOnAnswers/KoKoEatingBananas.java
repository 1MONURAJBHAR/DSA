/*
Find the minimum eating speed k such that Koko can finish all piles within h hours.
For a speed k, hours needed for one pile is:

pile/k

Total hours is the sum over all piles.

Since:
smaller k → more hours
larger k → fewer hours

this is a binary search problem.
*/

public class KoKoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int ans = Bananas(piles,h);
    }

    //binary search
    static int BananasBs(int[] piles, int h){
        int low = 1, high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long requiredHours = totalHours(piles, mid);

            if (requiredHours <= h) {
                high = mid - 1;   // try smaller speed
            } else {
                low = mid + 1;    // need higher speed
            }
        }

        return low;
    }


    //linear search
    static int Bananas(int[] piles, int h){
        int max = findMax(piles);

        //try every possible speed
        for (int k = 1; k <= max; k++){

            long hours = totalHours(piles, k);

            if (hours <= h){
                return k;  // first valid → minimum speed
            }
        }
        return max; // worst case
    }

    static int findMax(int[] piles){
        int max = piles[0];
        for (int pile : piles){
            max = Math.max(max, pile);
        }
        return max;
    }

    static long totalHours(int[] piles, int k){
       long total = 0;

       for (int pile : piles){
           total += (pile + k -1) / k; // ceil division
       }
       return total;
    }
}
