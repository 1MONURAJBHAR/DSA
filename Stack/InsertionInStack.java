import java.util.Stack;

public class InsertionInStack {

    // Insert value at given index (0-based from bottom)
    public static void insertAtIndex(Stack<Integer> st, int idx, int val) {
        // Edge case
        if (idx < 0 || idx > st.size()) {
            System.out.println("Invalid index");
            return;
        }

        Stack<Integer> temp = new Stack<>();

        // Move elements until we reach index
        while (st.size() > idx) {
            temp.push(st.pop());
        }

        // Insert element
        st.push(val);

        // Restore stack
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    //recursive approach
    public static void insertAtIndexRec(Stack<Integer> st, int idx, int val) {
        if (st.size() == idx) {
            st.push(val);
            return;
        }

        int top = st.pop();
        insertAtIndexRec(st, idx, val);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println("Original Stack: " + st);

        insertAtIndex(st, 2, 7);

        System.out.println("After Insertion: " + st);
    }
}