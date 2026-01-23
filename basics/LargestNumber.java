package basics;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter three numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //Q: find the largest of three numbers
//        if(a>b && a>c){
//            System.out.println("Largest number is:"+a);
//        }else if(b>a && b>c){
//            System.out.println("Largest number is:"+b);
//        }else{
//            System.out.println("Largest number is:"+c);
//        }

//        int max = a;
//         if(b>max){
//            max = b;
//        }
//         if(c>max){
//             max = c;
  //       }

         int max = Math.max(c, Math.max(a, b));

        System.out.println(max);

    }
}
