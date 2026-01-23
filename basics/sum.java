package basics;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        int a = sc.nextInt();  //will not take float value
        //float a1 = sc.nextInt();

        System.out.println("Enter second number:");
        int b = sc.nextInt();  //will not take float value
        //float b1 = sc.nextInt();

        int sum = a+b;

        System.out.println("Sum = " + sum);

        sc.close();
    }
}
