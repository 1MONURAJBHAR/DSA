package basics;

import java.lang.reflect.Array;
import java.util.Arrays;
 //VarArgs means we can give any number of inputs
public class VarArgs {
    public static void main(String[] args) {
       // fun(2,3,4,5,5,6,6,7,8,9);
        multiple(2,4,"Monu", "Rajbhar","Chandan");
    }

    static void multiple(int a, int b, String ...v){  //String ...v: always came at the last. variable length arguments always come at the end.
        System.out.println();
    }

    static void fun(int ...v){   //variable length arguement, length can vary.
        System.out.println(Arrays.toString(v));
    }
}
