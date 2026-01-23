package basics;

import java.util.Scanner;

public class occurences {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number: ");
//        int input = sc.nextInt();

        int n = 455365;

        int count = 0;
        while( n > 0) {
            int rem = n % 10; //takes the last value
            if(rem == 5){
                count++;
            }
            n = n/10;  //removes the last value
        }
        System.out.println(count);
    }
}
