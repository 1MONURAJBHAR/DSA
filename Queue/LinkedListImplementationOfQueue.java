public class LinkedListImplementationOfQueue {

    // Node class (represents each element in queue)
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue class
    static class Queue {
        private Node front; // points to first element  //head
        private Node rear;  // points to last element  //tail
        private int size;   // tracks number of elements

        // Constructor
        Queue() {
            front = rear = null;
            size = 0;
        }

        // Enqueue operation (add element at rear)
        public void add(int val) {
            Node newNode = new Node(val);

            // If queue is empty
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode; // link new node
                rear = newNode;      // move rear pointer
            }

            size++;
        }

        // Dequeue operation (remove element from front)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }

            int val = front.data;
            front = front.next; // move front forward

            // If queue becomes empty after removal
            if (front == null) {
                rear = null;
            }

            size--;
            return val;
        }

        // Peek (get front element without removing)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return front.data;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Get current size
        public int size() {
            return size;
        }

        // Display queue elements
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return;
            }

            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.print("Queue: ");
        q.display();  // 10 20 30 40

        System.out.println("Removed: " + q.remove());

        System.out.print("After removal: ");
        q.display();  // 20 30 40

        System.out.println("Front element: " + q.peek());

        System.out.println("Size: " + q.size());
    }
}