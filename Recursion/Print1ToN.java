import java.util.Scanner;

public class Print1ToN {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num1 = sc.nextInt();
//        printName(1, num2);
//        printLinearNumber(1, num2);
//        printLinearNumberReverse(1, num2);
        printLinearNumberReverseV2(num1, num1);
    }

    //print name n times
   // T.C --> O(n), space complexity --> O(n)
    static void printName(int i, int n){
        if(i>n) return;

        System.out.println("Monu Rajbhar");

        printName(i+1, n);
    }

    static void printLinearNumber(int i, int n){
        if(i>n) return;

        System.out.println(i);

        printLinearNumber(i+1, n);
    }

    static void printLinearNumberReverse(int i, int n){
        if(i>=n) return;

        System.out.println(n-i);

        printLinearNumberReverse(i+1, n);
    }

    static void printLinearNumberReverseV2(int i, int n){
        if(i<1) return;

        System.out.println(i);

        printLinearNumberReverseV2(i-1, n);
    }
}
