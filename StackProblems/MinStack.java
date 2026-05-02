import java.util.Stack;

public class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minSt;


    /*
    * // Constructor: Initializes the MinStack object
    public MinStack() {

        // 'st' is the main stack:
        // - Stores all the elements pushed by the user
        // - Follows standard LIFO (Last In First Out) behavior
        st = new Stack<>();

        // 'minSt' is an auxiliary (helper) stack:
        // - Keeps track of the minimum elements at each stage
        // - The top of this stack always holds the current minimum
        // - We only push values into minSt when:
        //      1. It is empty, OR
        //      2. The new value is <= current minimum
        // - This ensures we can retrieve the minimum in O(1) time
        minSt = new Stack<>();
    }   */

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
   /* public void pop() {
        if (st.peek().equals(minSt.peek())) {
            minSt.pop();
        }
        st.pop();
    }*/

    public int pop() {
        if (st.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int removed = st.pop();

        if (removed == minSt.peek()) {
            minSt.pop();
        }

        return removed;
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

        //Both stacks are initialized at the same time through the constructor.
        //Important Understanding:
        // You are not creating two separate objects manually
        // They are instance variables initialized together
        //After this line:
        //MinStack ms = new MinStack();
        //Internally:
        //ms
        // ├── st     → empty stack []
        // └── minSt  → empty stack []

        //Common Confusion (clear this)
        //Not like:
        //Stack s1 = new Stack();
        //Stack s2 = new Stack();
        //That would be separate objects
        //Here:
        //Both stacks belong to one MinStack object
        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Current Min: " + ms.getMin()); // 2


        int x = ms.pop();
        System.out.println("Removed: " + x);

        System.out.println("After pop, Min: " + ms.getMin()); // 3

        System.out.println("Top element: " + ms.top()); // 7

        ms.pop();
        System.out.println("After pop, Min: " + ms.getMin()); // 3
    }
}