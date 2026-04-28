public class ReverseLinkedList {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void displayrev(Node head){
        /*Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();*/

        if (head == null) return;
        displayrev(head.next);
        System.out.print(head.val+" ");
    }

    public static void display(Node head){
        if (head == null) return;
        System.out.print(head.val+" ");
        display(head.next);
    }


    public static Node reverse(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);

        head.next.next = head; // reverse link
        head.next = null;      // IMPORTANT FIX

        return newHead;
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(1);
        Node d = new Node(2);
        Node e = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        display(a);
        System.out.println();

        Node r = reverse(a);

        display(r);
    }
}
