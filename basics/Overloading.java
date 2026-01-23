package basics;

import java.util.Arrays;

//two or more functions with the same name can exists with different parameters
//Either the no. of arguments should be different or type of argument should be different
public class Overloading {
    public static void main(String[] args) {
//      fun(67);
//      fun("Kunal Kushwaha");

//        System.out.println(sum(2,3));
//        System.out.println( sum(2,3,4));

       demo(1,2,3,4,5,6,7,8,9);
       demo("Monu","Rajbhar","Chandan");
       //demo(); will cause error, this is known as ambuiguity.
    }

    static void demo(int ...v){
        System.out.println(Arrays.toString(v));
    }

    static void demo(String ...v){
        System.out.println(Arrays.toString(v));
    }


    static  int sum(int a, int b, int c){
        return a + b + c;
    }

    static  int sum(int a, int b){
        return a + b;
    }

    static void fun(int a){
        System.out.println("first one...");
        System.out.println(a);
    }
    static void fun(String name){
        System.out.println("Second one");
        System.out.println(name);
    }
}
