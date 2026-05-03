public class ArrayImplemantationOfQueue2 {

    static class Queue {
        int f = -1;   // front
        int r = -1;   // rear
        int size = 0;
        int[] arr = new int[5];

        // Add element (enqueue)
        public void add(int val) {
            if (r == arr.length - 1) {
                System.out.println("Queue is full!");
                return;
            }

            if (f == -1) { // first element
                f = r = 0;
                arr[r] = val;
            } else {
                arr[++r] = val;
            }

            size++;
        }

        // Remove element (dequeue)
        public int remove() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }

            int val = arr[f];
            f++;
            size--;

            // Reset when queue becomes empty
            if (size == 0) {
                f = r = -1;
            }

            return val;
        }

        // Peek front
        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return arr[f];
        }

        // Display queue
        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty!");
                return;
            }

            for (int i = f; i <= r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.add(10);
        q.add(20);
        q.add(30);

        q.display();   // 10 20 30

        System.out.println("Removed: " + q.remove());

        q.display();   // 20 30

        System.out.println("Front: " + q.peek());
    }
}