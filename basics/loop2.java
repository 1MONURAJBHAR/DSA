package basics;

import java.util.Scanner;

public class loop2 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
       /*
       syntax of for loop

       for(initialization; condition; increment;){
          //body
        }
       * */

        //print numbers from 1 to 5
//        for (int num = 1; num<=5; num++){
//            System.out.println(num);
//        }

//        for(int num = 1; num<=5; num += 2){
//            System.out.println(num);
//        }

        //print numbers from 1 to n
//        System.out.println("Enter the value of n:");
//        int n = sc.nextInt();
//        for(int num = 0; num<=n; num++){
//            System.out.print(num+" ");
//        }


        /*
        while loop
        syntax:
        while(condition){
         //body
        }
        * */

//        int count = 0;
//        while(count<=n){
//            System.out.println(count);
//            count++;
//        }

        /*
        do{

        }while(condition)
        * */

        int n1 = 1;
        do{
            System.out.println(n1);
            n1++;
        }while(n1 <= 9);
    }
}
