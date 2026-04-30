import java.util.Stack;

public class StackOperations {

    // Display stack (without modifying)
    public static void display(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        while (!temp.isEmpty()) {
            int val = temp.pop();
            System.out.print(val + " ");
            st.push(val);
        }
        System.out.println();
    }

    // Get top element
    public static int peek(Stack<Integer> st) {
        if (st.isEmpty()) throw new RuntimeException("Stack is empty");
        return st.peek();
    }

    // Insert at bottom
    public static void pushAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }

        int top = st.pop();
        pushAtBottom(st, val);
        st.push(top);
    }

    // Reverse stack (Important)
    public static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        reverse(st);
        pushAtBottom(st, top);
    }

    // Get bottom element
    public static int getBottom(Stack<Integer> st) {
        int top = st.pop();

        if (st.isEmpty()) {
            st.push(top);
            return top;
        }

        int bottom = getBottom(st);
        st.push(top);

        return bottom;
    }

    // Size (without using st.size())
    public static int size(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        int count = 0;

        while (!st.isEmpty()) {
            temp.push(st.pop());
            count++;
        }

        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }

        return count;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        // Push
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.print("Stack: ");
        display(st);

        // Peek
        System.out.println("Top element: " + peek(st));

        // Pop
        System.out.println("Popped: " + st.pop());

        // Display
        System.out.print("After pop: ");
        display(st);

        // Push at bottom
        pushAtBottom(st, 5);
        System.out.print("After push at bottom: ");
        display(st);

        // Get bottom
        System.out.println("Bottom element: " + getBottom(st));

        // Reverse
        reverse(st);
        System.out.print("After reverse: ");
        display(st);

        // Size
        System.out.println("Size: " + size(st));
    }
}