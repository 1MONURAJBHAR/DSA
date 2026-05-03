import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    static class MyStack {

        private Queue<Integer> q1;
        private Queue<Integer> q2;

        // Constructor
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        // Push element onto stack
        public void push(int x) {
            q2.add(x);

            // Move all elements from q1 → q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            // Swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            System.out.println("Pushed: " + x);
        }

        // Remove top element
        public int pop() {
            int val = q1.remove();
            System.out.println("Popped: " + val);
            return val;
        }

        // Get top element
        public int top() {
            int val = q1.peek();
            System.out.println("Top element: " + val);
            return val;
        }

        // Check if stack is empty
        public boolean empty() {
            boolean isEmpty = q1.isEmpty();
            System.out.println("Is Empty: " + isEmpty);
            return isEmpty;
        }
    }

    public static void main(String[] args) {

        MyStack st = new MyStack();

        st.push(10);
        st.push(20);
        st.push(30);

        st.top();    // should print 30

        st.pop();    // removes 30
        st.top();    // should print 20

        st.push(40);

        st.pop();    // removes 40
        st.pop();    // removes 20

        st.empty();  // false

        st.pop();    // removes 10

        st.empty();  // true
    }
}
