import java.util.Scanner;
import java.util.Stack;

public class CopyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();


        //take input from user
        int n;
        System.out.println("Enter the number of elements you want to insert : ");
        n = sc.nextInt();

        System.out.println("Enter the elements : ");
        for (int i = 1; i <= n; i++){
            int x = sc.nextInt();
            st.push(x);
        }
        System.out.println(st);

        //reverse a elements of stack
        Stack<Integer> rt = new Stack<>();
        while(st.size() > 0){
            int x = st.peek();
            rt.push(x);
            st.pop();

            //or rt.push(st.pop());
        }
        System.out.println(rt);

        Stack<Integer> gt = new Stack<>();
        while(rt.size() > 0){
            int x = rt.peek();
            gt.push(x);
            rt.pop();

            //or gt.push(r t.pop());
        }
        System.out.println(gt);
    }
}
