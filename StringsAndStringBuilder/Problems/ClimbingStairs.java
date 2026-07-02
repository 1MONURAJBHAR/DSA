public class ClimbingStairs {

    public static int climbStairs(int n) {

        if (n <= 2)
            return n;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }

        return second;
    }

    public static void main(String[] args) {

        int n1 = 2;
        int n2 = 3;
        int n3 = 5;

        System.out.println("n = " + n1 + " -> " + climbStairs(n1));
        System.out.println("n = " + n2 + " -> " + climbStairs(n2));
        System.out.println("n = " + n3 + " -> " + climbStairs(n3));
    }
}