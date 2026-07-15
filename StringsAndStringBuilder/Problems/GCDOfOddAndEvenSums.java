import java.util.Scanner;

public class GCDOfOddAndEvenSums {

    public static int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n * (n + 1);
        return gcd(sumOdd, sumEven);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int ans = gcdOfOddEvenSums(n);

        System.out.println("GCD of Odd and Even Sums = " + ans);

        sc.close();
    }
}