package basics;

import java.util.Scanner;

public class Sum2 {
    public static void main(String[] args) {
//     int ans = sum();
//     System.out.println("Sum of two numbers is: "+ans);
        int sol = sum3(3,4);
        System.out.println(sol);
    }

    //pass the value of numbers when you are calling the method in main()
    static int sum3(int a, int b){
        int sum = a+b;
        return sum;
    }



    static int sum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter your number 2: ");
        int num2 = sc.nextInt();

        int sum = num1+num2;
        //System.out.println("Sum of two numbers is: "+sum);

        return sum;
    }

//    static void sum() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number 1: ");
//        int num1 = sc.nextInt();
//        System.out.println("Enter your number 2: ");
//        int num2 = sc.nextInt();
//
//        int sum = num1+num2;
//        System.out.println("Sum of two numbers is: "+sum);
//    }
}
