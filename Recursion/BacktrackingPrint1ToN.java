import java.util.Scanner;

public class BacktrackingPrint1ToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num1 = sc.nextInt();

//        Backtrack(num1, num1);
        BacktrackV2(1, num1);
    }

    //print 1 to N using Backtracking
    static void Backtrack(int i, int n){
        if(i < 1) return;

        Backtrack(i-1, n);

        System.out.println(i);
    }

    //print N to 1 using Backtracking
    static void BacktrackV2(int i, int n) {
        // Base Case: Stop when i exceeds n
        if (i > n) return;

        // Recursive Call: Wait for the next number to finish
        BacktrackV2(i + 1, n);

        // Backtracking Step: Print i as the functions pop off the stack
        System.out.println(i);
    }
}
