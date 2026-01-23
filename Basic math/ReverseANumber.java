import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int input = sc.nextInt();
        int ans = Reverse(input);
        System.out.println("Reversed number: "+ans);

    }
    static int Reverse(int n){
        int ans = 0;
        while(n != 0){
            int rem = n%10;
            ans = ans*10 + rem;
            n = n / 10;
        }
        return ans;
    }
}
