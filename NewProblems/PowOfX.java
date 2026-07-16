public class PowOfX {
    public static void main(String[] args) {

        double x = 2;
        int n = 10;

        double ans = myPow(x, n);

        System.out.println(x + "^" + n + " = " + ans);
    }

    public static double myPow(double x, int n) {
        return solve(x, (long) n);
    }

    public static double solve(double x, long n) {

        // Base case
        if (n == 0)
            return 1;

        // Negative exponent
        if (n < 0)
            return solve(1 / x, -n);

        // Even exponent
        if (n % 2 == 0)
            return solve(x * x, n / 2);

        // Odd exponent
        return x * solve(x * x, (n - 1) / 2);
    }
}
