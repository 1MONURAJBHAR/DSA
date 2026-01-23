import java.util.Scanner;

public class PrintFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num1 = sc.nextInt();
        int ans = Factorial(num1);
        System.out.println("Factorial of number is: "+ans);
    }

    //T.C --> O(n), S.C --> O(n)
    static int Factorial(int n) {
        if (n < 0) return -1; // invalid
        if (n == 0) return 1;
        return n * Factorial(n - 1);
    }
}
