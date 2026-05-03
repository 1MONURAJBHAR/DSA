import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class displayQueue {

    // Function to display queue using two queues
    public static void display(Queue<Integer> q) {
        Queue<Integer> helper = new LinkedList<>();
       // Queue<Integer> helper = new ArrayDeque<>();

        // Move elements to helper and print
        while (!q.isEmpty()) {
            int val = q.remove();
            System.out.print(val + " ");
            helper.add(val);
        }

        // Restore original queue
        while (!helper.isEmpty()) {
            q.add(helper.remove());
        }
    }



    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);


        System.out.print("Queue elements: ");
        display(q);

        System.out.println("\nAfter display (queue still intact): " + q);
    }
}
