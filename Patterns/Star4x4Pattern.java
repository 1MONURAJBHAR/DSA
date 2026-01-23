import java.util.Scanner;

public class Star4x4Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int input = sc.nextInt();
//        printPattern(input);  //nxn star pattern
//        printPattern2(input); //right angle triangle pattern for star
//        printPattern3(input);  //right angle triangle pattern for numbers
//        printPattern4(input);
//        printPattern5(input);
//        printPattern6(input);
//          printPattern7(input);
//          printPattern8(input);
//        printPattern9(input);
//        printPattern10(input);
//        printPattern11(input);
//        printPattern11V2(input);
//        printPattern12(input);
//        printPattern13(input);
//        printPattern14(input);
//        printPattern15(input);
//        printPattern16(input);
//        printPattern18(input);
//        printPattern17(input);
//        printPattern19(input);
//        printPattern20(input);
//        printPattern21(input);
        printPattern22(input);
    }

    static void printPattern(int n) {
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern2(int n) {
        for (int row = 0; row<n; row++){
            for (int col = 0; col<=row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPattern3(int n) {
            for (int row = 0; row<n; row++){
                for (int col = 0; col<=row; col++){
                    System.out.print(col+1+" ");
                }
                System.out.println();
            }
    }

    static void printPattern4(int n) {
            for (int row = 0; row<n; row++){
                for (int col = 0; col<=row; col++){
                    System.out.print(row+1+" ");
                }
                System.out.println();
            }
    }

    static void printPattern5(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < (n - row); col++) {
                System.out.print(col+1 + " ");
            }
            System.out.println();
        }
    }
    //same logic just start from 1
    static void printPattern5_V2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col < (n - row + 1); col++) {
                System.out.print(col+1 + " ");
            }
            System.out.println();
        }
    }

    static void printPattern6(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < (n - row); col++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    //upper triangle
    static void printPattern7(int n) {
        for (int row = 0; row < n; row++) {

            // spaces
            for (int sp = 0; sp < (n - row - 1); sp++) {
                System.out.print("  ");
            }

            // stars
            for (int col = 0; col < (2 * row + 1); col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    //lower triangle
    static void printPattern8(int n) {
        for (int row = 0; row < n; row++) {

            // spaces
            for (int sp = 0; sp < row; sp++) {
                System.out.print("  ");
            }

            // stars,  or 2n-(2 * row + 1), both are same.
            for (int col = 0; col < (2 * (n - row) - 1); col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void printPattern9(int n) {
        printPattern7(n);
        printPattern8(n);
    }

    static void printPattern10(int n) {
       for (int i = 0; i < 2*n - 1; i++){

           int stars;
           if(i < n){
               stars = i + 1;
           }else{
               stars = 2*n - i -1;
           }
           for (int j = 0; j < stars; j++){
               System.out.print("* ");
           }
           System.out.println();
       }
    }

    static void printPattern10V2(int n) {
        for (int i = 1; i <= 2*n - 1; i++){
            int stars = i;
            if(i > n) stars = 2*n - i;
            for (int j = 1; j <= stars; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    //starting from 1
    static void printPattern11(int n) {
        for (int i = 1; i <= n; i++) {

            int start = (i % 2 == 0) ? 0 : 1;  // row start

            for (int j = 1; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 - start; // toggle 0 <-> 1
            }

            System.out.println();
        }
    }

    //starting from 0
    static void printPattern11V2(int n) {
        for (int i = 0; i<n; i++){
            int start;
            if(i%2 == 0){
                start = 1;
            }else{
                start = 0;
            }

            for (int j = 0; j<=i; j++){
                System.out.print(start+ " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    static void printPattern12(int n) {
        for (int i = 1; i <= n; i++) {

            // left numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // spaces (2*(n-i))
            int spaces = 2 * (n - i);
            for (int s = 0; s < spaces; s++) {
                System.out.print(" ");
            }

            // right reversed numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }


    static void printPattern13(int n){
        int num = 1;
        for (int i = 1; i<=n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }

    static void printPattern14(int n){
        for (int i = 0; i<n; i++){
            for (char ch = 'A'; ch<='A'+i; ch++){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    static void printPattern15(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch < 'A' + (n - i); ch++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    static void printPattern16(int n){
        for (int i = 0; i<n; i++){
            char ch = (char)('A'+i);
            for (int j = 0; j<=i; j++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    static void printPattern17v1(int n) {
        for (int i = 1; i <= n; i++) {

            // spaces
            for (int spaces = 0; spaces < n - i; spaces++) {
                System.out.print(" ");
            }

            // increasing part: A to (A + i - 1)
            for (char ch = 'A'; ch < 'A' + i; ch++) {
                System.out.print(ch);
            }

            // decreasing part: (A + i - 2) to A
            for (char ch = (char) ('A' + i - 2); ch >= 'A'; ch--) {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    static void printPattern17(int n) {
        for (int i = 0; i < n; i++) {

            // spaces
            for (int spaces = 0; spaces < n - i - 1; spaces++) {
                System.out.print(" ");
            }

            char ch = 'A';
            int breakpoint = (2 * i + 1) / 2;

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(ch);

                if (j < breakpoint) ch++;
                else ch--;
            }

            System.out.println();
        }
    }

    static void printPattern18(int n) {
        for (int i = 0; i < n; i++) {

            char start = (char) ('A' + (n - 1 - i));  //take the last value

            for (char ch = start; ch <= 'A' + (n - 1); ch++) {
                System.out.print(ch + " ");
            }

            System.out.println();
        }
    }


    static void printPattern19(int n) {

        // upper half
        for (int i = 0; i < n; i++) {

            // left stars
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }

            // middle spaces
            for (int j = 0; j < 2 * i; j++) {
                System.out.print("  ");
            }

            // right stars
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // lower half
        for (int i = 0; i < n; i++) {

            // left stars
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            // middle spaces
            for (int j = 0; j < 2 * (n - i - 1); j++) {
                System.out.print("  ");
            }

            // right stars
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void printPattern20(int n) {
        int spaces = 2 * n - 2;

        for (int i = 1; i <= 2 * n - 1; i++) {

            int stars = i;
            if (i > n) stars = 2 * n - i;

            // left stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            // middle spaces (IMPORTANT: use 2 spaces)
            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }

            // right stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            System.out.println();

            if (i < n) spaces -= 2;
            else spaces += 2;
        }
    }

    static void printPattern21(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    static void printPattern22(int n){
        for (int i = 0; i < 2*n-1; i++){
            for (int j = 0; j < 2*n-1; j++){
                int top = i;
                int left = j;
                int right = (2*n-2) - j;
                int down = (2*n-2) - i;
                System.out.print(n - Math.min( Math.min(top,down), Math.min(left, right)));
             }
            System.out.println();
        }
    }

}
