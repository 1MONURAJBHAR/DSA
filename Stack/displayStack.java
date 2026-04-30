import java.util.Stack;

public class displayStack {

    public static void display(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();

        // Reverse into temp
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        // Print + restore
        while (!temp.isEmpty()) {
            int val = temp.pop();
            System.out.print(val + " ");
            st.push(val); // restore original stack
        }

        System.out.println();
    }

    public static void displayUsingArray(Stack<Integer> st) {
        int n = st.size();
        int[] arr = new int[n];

        // Fill array (reverse order)
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }

        // Print + restore
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            st.push(arr[i]);
        }

        System.out.println();
    }

    //Print from Bottom → Top
    public static void displayRec(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        displayRec(st);          // go deeper
        System.out.print(top + " ");
        st.push(top);            // restore
    }

    //Print from Top → Bottom
    public static void displayReverseRec(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        System.out.print(top + " ");
        displayReverseRec(st);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        display(st);
        System.out.println("After display: " + st);
    }
}