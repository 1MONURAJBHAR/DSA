import java.util.LinkedList;
import java.util.Queue;

public class BasicQueue {
    public static void main(String[] args) {

        // Queue interface implemented using LinkedList
        // Follows FIFO (First In First Out)
        Queue<Integer> q = new LinkedList<>();

        // Adding elements to the queue (enqueue operation)
        // add() throws exception if insertion fails
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // Printing entire queue
        System.out.println("Initial Queue: " + q);

        //Returns the number of elements currently in the queue
        System.out.println("Size of queue is : "+q.size());

        // remove() removes the front element
        // Throws exception if queue is empty
        q.remove();
        System.out.println("After remove(): " + q);

        // poll() removes the front element
        // Returns null if queue is empty (safe operation)
        q.poll();
        System.out.println("After poll(): " + q);

        // peek() & element() returns front element without removing it
        System.out.println("Front element using peek(): " + q.peek());

        System.out.println("Size of queue is : "+q.size());

        //check queue is empty or not,  isEmpty(): returns boolean true or false
        System.out.println("Is queue empty : "+q.isEmpty());

    }
}