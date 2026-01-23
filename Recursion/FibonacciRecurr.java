import java.util.Scanner;

public class FibonacciRecurr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        int ans = FindNthFibonacci(n);
        System.out.println(ans);
    }

    //T.C --> approx O(2^n)
    static int FindNthFibonacci(int n){
        if(n <= 1) return n;
        int last = FindNthFibonacci(n-1);
        int secondLast = FindNthFibonacci(n-2);
        return last+secondLast;
    }
}
