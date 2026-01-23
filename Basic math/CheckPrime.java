import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int input  = sc.nextInt();
       // boolean ans = isPrime(input);
        boolean ans = isPrimeV2(input);
        System.out.println("Is Prime: "+ans);
    }

    //not efficient time complexity --> O(n)
    static boolean isPrime(int n) {
        int divisibleFactors = 0;
        for (int i = 1; i <= n; i++){
            if(n%i == 0){
                divisibleFactors++;
            }
        }
        return divisibleFactors == 2;
    }

    //Efficient One  T.C--> O(sqrt(n))
    static boolean isPrimeV2(int n){
        int divisibleFactors = 0;
        for (int i = 1; i * i <= n; i++){
            if (n % i == 0){
                divisibleFactors++;

                if (n/i != i){
                    divisibleFactors++;
                }
            }
        }
        return divisibleFactors == 2;
    }
}
