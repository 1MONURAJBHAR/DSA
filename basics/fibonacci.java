package basics;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int input = sc.nextInt();

       int a = 0, b = 1;

       //print fibonacci number
//       while(a<=input){
//          // System.out.print(a+" ");
//           int next = a+b;
//           a = b;
//           b = next;
//       }
//       sc.close();

       //If you want only the largest Fibonacci number ≤ input
//        while (b <= input) {
//            int next = a + b;
//            a = b;
//            b = next;
//        }
//
//        System.out.println(a);
//        sc.close();

        //Fibonacci number at nth position
        int count = 2;
        while(count<=input){
            int temp = b;
            b = a+b; //next fibonacci number
            a = temp;  //next value of a
            count++;
        }
        System.out.println("Nth fibonacci number is "+b);

    }
}
