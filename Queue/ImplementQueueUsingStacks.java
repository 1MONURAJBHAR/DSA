import java.util.Stack;

public class ImplementQueueUsingStacks {

    static class MyQueue {

        private Stack<Integer> inStack;   // used for push
        private Stack<Integer> outStack;  // used for pop/peek

        // Constructor
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        // Push element to the back of queue
        public void push(int x) {
            inStack.push(x);
            System.out.println("Pushed: " + x);
        }

        // Remove element from front
        public int pop() {
            shiftStacks();
            int val = outStack.pop();
            System.out.println("Popped: " + val);
            return val;
        }

        // Get front element
        public int peek() {
            shiftStacks();
            int val = outStack.peek();
            System.out.println("Front element: " + val);
            return val;
        }

        // Check if queue is empty
        public boolean empty() {
            boolean isEmpty = inStack.isEmpty() && outStack.isEmpty();
            System.out.println("Is Empty: " + isEmpty);
            return isEmpty;
        }

        // Move elements only when needed
        private void shiftStacks() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }

    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        q.push(10);
        q.push(20);
        q.push(30);

        q.peek();     // should print 10

        q.pop();      // removes 10
        q.peek();     // should print 20

        q.push(40);

        q.pop();      // removes 20
        q.pop();      // removes 30

        q.empty();    // false

        q.pop();      // removes 40

        q.empty();    // true
    }
}