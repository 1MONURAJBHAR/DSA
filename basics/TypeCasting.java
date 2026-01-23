package basics;

import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        //conditions for type casting
        //condition1: two types should be compatible
        //condition2: destination type > source type
        Scanner sc = new Scanner(System.in);

        //assign int to float
//        float num = sc.nextFloat(); //float > integer
//        System.out.println(num);

        //convert float to int, this is known as typeCasting --> compressing the bigger number into smaller type explicitly.
//        int num2 = (int)(67.55f);
//        System.out.println(num2);


        //automatic type promotion in expressions

//        int a = 257;
//        byte b = (byte)(a);  //257 % 256 = 1, 1byte = 256 <-- space
//        System.out.println("byte"+b);

//        byte a = 40;
//        byte b = 50;
//        byte c = 100;
//
//        int d = ( a * b) / c;
//
//        System.out.println(d);

//        int number = 'a';
//        System.out.println(number); //gives AscII values

        //java follows unicode principal
        System.out.println("नमस्ते");
        System.out.println("你好");
    }
}
