import java.util.Stack;

public class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minSt;

    // Constructor
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    // Push element
    public void push(int val) {
        st.push(val);

        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

    // Pop element
    public void pop() {
        if (st.peek().equals(minSt.peek())) {
            minSt.pop();
        }
        st.pop();
    }

    // Get top element
    public int top() {
        return st.peek();
    }

    // Get minimum element
    public int getMin() {
        return minSt.peek();
    }

    // Main method (testing)
    public static void main(String[] args) {

        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Current Min: " + ms.getMin()); // 2

        ms.pop();
        System.out.println("After pop, Min: " + ms.getMin()); // 3

        System.out.println("Top element: " + ms.top()); // 7

        ms.pop();
        System.out.println("After pop, Min: " + ms.getMin()); // 3
    }
}