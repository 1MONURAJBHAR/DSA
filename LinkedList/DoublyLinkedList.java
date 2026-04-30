public class DoublyLinkedList {
   public static class Node{
       int val;
       Node next;
       Node prev;

       Node(int val){
           this.val = val;
           this.next = null;
           this.prev = null;
       }
   }

   public static void display(Node head){
       Node temp = head;

       while(temp != null){
           System.out.print(temp.val+" ");
           temp = temp.next;
       }
       System.out.println();
   }

    public static void displayrev(Node tail){
        Node temp = tail;

        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void displayListUsingRandomNode(Node random){
        Node temp = random;

        //Move this temp backward to the head
        while(temp.prev != null){
            temp = temp.prev;
        }

        //now temp is at head
        //print the list
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node insertAtHead(Node head, int val) {
        Node newNode = new Node(val);

        // If list is empty
        if (head == null) {
            return newNode;
        }

        // Link new node with old head
        newNode.next = head;
        head.prev = newNode;

        // New node becomes head
        return newNode;
    }

    public static Node insertAtTail(Node head, int val) {
        Node newNode = new Node(val);

        // If list is empty
        if (head == null) {
            return newNode;
        }

        Node temp = head;

        // Traverse to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Attach new node
        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    //Using 2-Pointer (temp method)
    public static Node insertAtIndex_2Pointer(Node head, int index, int val) {
        Node t = new Node(val);

        // Case 1: insert at head
        if (index == 0) {
            t.next = head;
            if (head != null) head.prev = t;
            return t;
        }

        Node temp = head;
        int i = 0;

        // Move temp to (index - 1)
        while (temp != null && i < index - 1) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        // Core logic (same as your image)
        if (temp.next != null) {
            temp.next.prev = t;
        }

        t.prev = temp;
        t.next = temp.next;
        temp.next = t;

        return head;
    }

    //Using 3-Pointer (S, R, T method)
    // S = left node
    // R = right node
    // T = new node
    public static Node insertAtIndex_3Pointer(Node head, int index, int val) {
        Node t = new Node(val);

        // Insert at head
        if (index == 0) {
            t.next = head;
            if (head != null) head.prev = t;
            return t;
        }

        Node s = head;

        // Move s to (index - 1)
        for (int i = 0; i < index - 1; i++) {
            if (s == null) {
                System.out.println("Index out of bounds");
                return head;
            }
            s = s.next;
        }

        if (s == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        Node r = s.next; // right node

        // EXACT sequence (very important)
        s.next = t;
        t.prev = s;
        t.next = r;

        if (r != null) {
            r.prev = t;
        }

        return head;
    }


    //Delete Tail (when only head is given)
    public static Node deleteTail(Node head) {

        // Empty list
        if (head == null) return null;

        // Only one node
        if (head.next == null) return null;

        Node temp = head;

        // Reach last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Move to second last
        temp = temp.prev;

        // Break link
        temp.next = null;

        return head;
    }

    //Delete at Index (3-pointer approach — IMPORTANT)
    public static Node deleteAtIndex(Node head, int index) {

        // Empty list
        if (head == null) return null;

        // Delete head
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            return head;
        }

        Node temp = head;

        // Move to (index - 1)
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) {
                System.out.println("Index out of bounds");
                return head;
            }
            temp = temp.next;
        }

        // If node to delete doesn't exist
        if (temp == null || temp.next == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        Node toDelete = temp.next;
        Node r = toDelete.next;

        // Core logic (from your image)
        temp.next = r;

        if (r != null) {
            r.prev = temp;
        }

        return head;
    }

//    Delete Tail (only tail is given)
    public static Node deleteTailUsingTail(Node tail) {

        // Empty list
        if (tail == null) return null;

        // Only one node
        if (tail.prev == null) return null;

        Node newTail = tail.prev;

        // Break connection
        newTail.next = null;

        // Optional cleanup
        tail.prev = null;

        return newTail;
    }

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);


//        Node head = null;
//        head = insertAtHead(head, 10);
//        head = insertAtHead(head, 20);
//        head = insertAtHead(head, 30);
//
//        display(head); // 30 20 10
//
//        head = insertAtTail(head, 40);
//        head = insertAtTail(head, 50);
//
//        display(head); // 30 20 10 40 50


        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next = null;

        display(a);
        displayListUsingRandomNode(e);


    }
}
