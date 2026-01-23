import java.util.Scanner;

public class GcdHcf {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number: ");
            int n1  = sc.nextInt();
            int n2  = sc.nextInt();
            int ans = GCD(n1,n2);
            System.out.println("GCD is: "+ans);
    }

    //T.C --> O(min(n1,n2))
    static int GCD(int n1, int n2){
        int gcd = 1;
        for (int i = 1; i <= Math.min(n1, n2); i++){
            if (n1%i == 0 && n2%i ==0){
                gcd = i;
            }
        }
        return gcd;
    }
}
