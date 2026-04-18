public class findSqrt {
    public static void main(String[] args) {
        int ans = Sqrt(35);
        System.out.println(ans);
    }

    static int SqrtLinear1(int number) {
        int i = 0;

        while (i * i <= number) {
            i++;
        }

        return i - 1; // last valid i
    }

    static int SqrtLinear2(int number) {
        int ans = 0;

        for (int i = 0; i <= number; i++) {
            if ((long)i * i <= number) { // avoid overflow
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    static int Sqrt(int number) {
        int low = 0, high = number;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) mid * mid <= number) { // avoid overflow
                ans = mid;        // store possible answer
                low = mid + 1;    // try bigger
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}