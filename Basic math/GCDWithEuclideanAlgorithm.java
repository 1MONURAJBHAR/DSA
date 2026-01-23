import java.util.Scanner;

public class GCDWithEuclideanAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int gcd = GCDusingEuclideanAlgo(n1, n2);
        System.out.println("GCD: " + gcd);
    }

    //T.C --> O(log(phi)min(a,b))
    static int GCDusingEuclideanAlgo(int a, int b) {
        //handles negative numbers using Math.abs()
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0) return b;
        if (b == 0) return a;

        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return (a == 0) ? b : a;
    }
}
