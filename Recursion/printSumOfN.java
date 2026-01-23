import java.util.Scanner;

public class printSumOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num1 = sc.nextInt();
//        printSum(num1,0);
       int ans = printSumFunctional(num1);
        System.out.println(ans);
    }

    //parameterized method
    static void printSum(int i, int sum){
        if(i<1){
            System.out.println("Sum of N numbers: "+sum);
            return;
        }
        printSum(i-1, sum+i);
    }

    //functional method
    static int printSumFunctional(int n){
        if(n == 1){
            return 1;
        }
        return n + printSumFunctional(n-1);
    }
}
