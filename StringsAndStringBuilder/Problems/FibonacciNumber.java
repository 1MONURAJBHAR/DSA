public class FibonacciNumber {
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        System.out.println("Fibonacci of 2 = " + fib(2)); // 1
        System.out.println("Fibonacci of 3 = " + fib(3)); // 2
        System.out.println("Fibonacci of 4 = " + fib(4)); // 3
        System.out.println("Fibonacci of 5 = " + fib(5)); // 5
        System.out.println("Fibonacci of 10 = " + fib(10)); // 55
    }
}

