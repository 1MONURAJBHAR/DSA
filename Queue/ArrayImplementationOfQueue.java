
//Best and Optimal version
public class ArrayImplementationOfQueue {

    static class Queue {
        private int[] arr;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        // Constructor
        Queue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        // Enqueue (add element)
        public void add(int val) {
            if (isFull()) {
                System.out.println("Queue is Full!");
                return;
            }
            rear = (rear + 1) % capacity; // circular increment
            arr[rear] = val;
            size++;
        }

        // Dequeue (remove element)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            int val = arr[front];
            front = (front + 1) % capacity; // circular increment
            size--;
            return val;
        }

        // Peek (front element)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[front];
        }

        // Check empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Check full
        public boolean isFull() {
            return size == capacity;
        }

        // Display queue
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return;
            }

            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % capacity] + " ");
            }
            System.out.println();
        }

        public int size(){
            return size;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue(5);

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.print("Queue: ");
        q.display();

        System.out.println("Removed: " + q.remove());

        System.out.print("After removal: ");
        q.display();

        System.out.println("Front element: " + q.peek());
        System.out.println("Size of queue is : " + q.size());
    }
}