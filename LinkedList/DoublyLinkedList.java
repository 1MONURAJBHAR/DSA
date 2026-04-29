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
