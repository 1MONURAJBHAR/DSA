import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int input = sc.nextInt();
//        int ans = CountDigits1(input);  //time complexity --> O(log10(N))
        int ans = CountDigits2(input);    //time complexity --> O(log10(N))
        System.out.println("No of digits are: "+ans);
    }

    static int CountDigits1(int n){
        int count = 0;
        while(n != 0){  //will reverse -ve & +ve values
            //int rem = n%10;
            n = n/10;    //if it was divided by 2 then T.C --> O(log2(N)),if it was divided by 5 then T.C --> O(log5(N))
            count++;
        }
        return count;
    }


    static int CountDigits2(int n){
        int count = (int)(Math.log10(n) + 1);
        return count;
    }
}
