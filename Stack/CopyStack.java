import java.util.Scanner;
import java.util.Stack;

public class CopyStack {

    public static Stack<Integer> copyStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        // Step 1: reverse into temp
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        // Step 2: restore original + build copy
        while (!temp.isEmpty()) {
            int val = temp.pop();
            st.push(val);      // restore original
            copy.push(val);    // build copy
        }

        return copy;
    }

    public static Stack<Integer> copyStackRec(Stack<Integer> st) {
        Stack<Integer> copy = new Stack<>();
        copyHelper(st, copy);
        return copy;
    }

    private static void copyHelper(Stack<Integer> st, Stack<Integer> copy) {
        if (st.isEmpty()) return;

        int top = st.pop();
        copyHelper(st, copy);

        st.push(top);     // restore original
        copy.push(top);   // add to copy
    }


    public static Stack<Integer> copyStack2(Stack<Integer> st){
        //reverse a elements of stack
        Stack<Integer> rt = new Stack<>();
        while(st.size() > 0){
            int x = st.peek();
            rt.push(x);
            st.pop();

            //or rt.push(st.pop());
        }
        //System.out.println(rt);

        Stack<Integer> gt = new Stack<>();
        while(rt.size() > 0){
            int x = rt.peek();
            gt.push(x);
            rt.pop();

            //or gt.push(r t.pop());
        }
       // System.out.println(gt);
        return gt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        Stack<Integer> copied = copyStack(st);

        System.out.println("Original: " + st);
        System.out.println("Copied  : " + copied);
        System.out.println("Copied2  : " + copyStack2(st));

    }
}

/*
import java.util.*;

public class CopyStack {

    public static Stack<Integer> copyStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        // Step 1: reverse into temp
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        // Step 2: restore original + build copy
        while (!temp.isEmpty()) {
            int val = temp.pop();
            st.push(val);      // restore original
            copy.push(val);    // build copy
        }

        return copy;
    }

   public static Stack<Integer> copyStackRec(Stack<Integer> st) {
    Stack<Integer> copy = new Stack<>();
    copyHelper(st, copy);
    return copy;
}

    private static void copyHelper(Stack<Integer> st, Stack<Integer> copy) {
        if (st.isEmpty()) return;

        int top = st.pop();
        copyHelper(st, copy);

        st.push(top);     // restore original
        copy.push(top);   // add to copy
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        Stack<Integer> copied = copyStack(st);

        System.out.println("Original: " + st);
        System.out.println("Copied  : " + copied);
    }
}
* */