/*
Problem Understanding
You need to find integer x such that:

x^n = m
Examples:
n = 3, m = 27 → 3³ = 27 → answer = 3
n = 4, m = 69 → no integer satisfies → answer = -1
*/



public class NthSqrtOfM {
    public static void main(String[] args) {
        int ans = NthRoot(81, 2);
        System.out.println(ans);
    }

    //linear search
    static int NthRoot(int n, int m) {

        for (int i = 1; i <= m; i++) {

            long val = power(i, n, m);

            if (val == m) {
                return i;
            }
            else if (val > m) {
                break; // no need to continue
            }
        }

        return -1;
    }

    //binary search
    static int NthRootBs(int n, int m) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long val = power(mid, n, m);

            if (val == m) return mid;
            else if (val > m) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }


    // helper function to compute i^n safely
    static long power(int base, int exp, int limit) {
        long result = 1;

        for (int i = 0; i < exp; i++) {
            result *= base;

            if (result > limit) return result; // early stop
        }

        return result;
    }
}

