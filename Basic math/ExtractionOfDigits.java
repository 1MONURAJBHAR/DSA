import java.util.Scanner;

public class ExtractionOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int input = sc.nextInt();
        ExtractDigits(input);
    }

    static void ExtractDigits(int n){

        while(n>0){
            int rem = n%10;
            System.out.print(rem+" ");
            n = n/10;
        }
    }
}
