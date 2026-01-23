import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input  = sc.nextInt();
        System.out.println("Enter number: ");
        boolean ans = CheckP(input);
        System.out.println("Is Palindrome: "+ans);
    }

    static boolean CheckP(int n) {
        if (n < 0) return false;                 // negative's are not palindrome
        if (n != 0 && n % 10 == 0) return false; // numbers ending with 0 not palindrome

        int original = n;
        int rev = 0;

        while (n != 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }

        return rev == original;
    }
}
