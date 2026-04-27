public class findNthNodeFromEndOfLinkedlist {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

   /* public static Node nthNodeFromEnd(Node head, int n){
        int size = 0;
        Node temp = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        int m = size - n + 1;

        //mth node from start
        temp = head;
        for (int i = 1; i <= m-1; i++){
            temp = temp.next;
        }

        return temp;
    }*/

    public static Node nthNodeFromEnd(Node head, int n){
        Node slow = head;
        Node fast = head;

        for (int i = 1; i <= n; i++){
            fast = fast.next;
        }

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void display(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static Node removingNthNodeFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;

        // move fast n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) return head; // n > length
            fast = fast.next;
        }

        // if fast becomes null → delete head
        if (fast == null) {
            return head.next;
        }

        // move both pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // delete node
        slow.next = slow.next.next;

        return head;
    }





    public static void main(String[] args) {
            Node a = new Node(100);
            Node b = new Node(13);
            Node c = new Node(4);
            Node d = new Node(5);
            Node e = new Node(12);
            Node f = new Node(10);

            a.next = b;
            b.next = c;
            c.next = d;
            d.next = e;
            e.next = f;

            Node temp = nthNodeFromEnd(a, 3);

            display(a);
            Node removedNodeListHead =  removingNthNodeFromEnd(a,6);
            display(removedNodeListHead);

            if (temp != null)
                System.out.println(temp.data);
            else
                System.out.println("Index out of bounds");
    }
}
