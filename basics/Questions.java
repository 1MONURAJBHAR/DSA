package basics;

import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number: ");
//        int n = sc.nextInt();
       // boolean ans = isPrime(n);
      //  boolean ans = isArmstrong(n);
        //System.out.println(ans);

        //print all the three digit armstrong numbers
        for(int i = 100; i<1000; i++){
            if(isArmstrong(i)){
                System.out.print(i + " ");
            }
        }
    }

    //check the entered number is armstrong number or not.
    static boolean isArmstrong(int n){
        int Original = n;
        int ans = 0;
        while( n > 0 ){
            int rem = n%10;
            int cube = rem*rem*rem;
            ans += cube;
            n = n/10;
        }
        return ans == Original;  //it will either true or false
    }

//check prime
    static boolean isPrime(int n) {
        if (n <= 1) {
            return true;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
//        if (c * c > n) {
//            return true;
//        }
        return c * c > n;  //true or false
    }
}
