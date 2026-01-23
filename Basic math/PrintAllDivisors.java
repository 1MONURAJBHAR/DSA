import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrintAllDivisors {
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int input = sc.nextInt();
        //AllDivisors(input);
        ArrayList<Integer> list = AllDivisorsV2(input);
        Collections.sort(list);
        System.out.println(list);
    }

    static void AllDivisors(int n) {
        for (int i = 1; i<=n; i++){
            if(n%i == 0){
                System.out.print(i+" ");
            }
        }
    }

    //optimized version,T.C--> O(sqrt(n))
    static ArrayList<Integer> AllDivisorsV2(int n){
        ArrayList<Integer> list = new ArrayList<>();

        //double num = Math.sqrt(n);

        for (int i = 1; i*i <= n; i++){
            if(n%i == 0){

                list.add(i);

                if(n/i != i){
                   list.add(n/i);
                }
            }
        }
        return list;
    }
}
