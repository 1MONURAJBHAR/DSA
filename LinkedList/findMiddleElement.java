/*
Why this works:

slow → moves 1 step
fast → moves 2 steps

 When fast reaches end, slow is at middle
* */
public class findMiddleElement {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
    If interviewer asks variation
    First middle instead of second
    Change:
    Node fast = head.next;  or  fast.next.next = null; --> inside while loop, both have same meaning
    * */

    // Function to find middle node
    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move 1 step
            fast = fast.next.next;   // move 2 steps
        }

        return slow;
    }

    // Utility function to display list
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating linked list: 10 -> 20 -> 30 -> 40 -> 50
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.print("Linked List: ");
        display(a);

        Node middle = findMiddle(a);

        if (middle != null)
            System.out.println("Middle element: " + middle.data);
    }
}
