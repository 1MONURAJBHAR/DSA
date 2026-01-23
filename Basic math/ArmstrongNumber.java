import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int input  = sc.nextInt();
        boolean ans = isArmstrong(input);
        System.out.println("Is Armstrong: "+ans);
    }
//Armstrong number: 371
    static boolean isArmstrong(int n){
        int Original = n;
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += rem*rem*rem;
            n = n/10;
        }
        return sum == Original;
    }
}
