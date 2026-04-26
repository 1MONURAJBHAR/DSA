public class BasicsLL {
    public static class Node{
        int data;  //value
        Node next;  //address of the next node

        Node(int data){  //constructor of class node
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        System.out.println(a.next);  //null
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);
        //5  3  9  8  16
        a.next = b;   //5 -> 3  9  8  16
        b.next = c;   //5 -> 3 -> 9  8  16
        c.next = d;   //5 -> 3 -> 9 -> 8  16
        d.next = e;   //5 -> 3 -> 9 -> 8 -> 16

        //we can access all elements using head "a"
        System.out.println(a.data);
        System.out.println(a.next.data);
        System.out.println(a.next.next.data);
        System.out.println(a.next.next.next.data);
        System.out.println(a.next.next.next.next.data);
        insertAtEnd(a,90);
        display(a);
    }

    public static void insertAtEnd(Node head, int val){
        Node temp = new Node(val);

        Node t = head;

        while(t.next != null){    //t.next at last will point to null
            t = t.next;
        }

        t.next = temp;
    }

    //most important method
    public static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void displayUsingFor(Node head) {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " -> ");
        }
        System.out.println("null");
    }


    //Very useful for recursion-based questions.
    //5 -> 3 -> 9 -> 8 -> 16 -> null
    public static void displayRecursive(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        System.out.print(head.data + " -> ");
        displayRecursive(head.next);
    }

   // Frequently asked twist
    //16 -> 8 -> 9 -> 3 -> 5 ->
    public static void displayReverse(Node head) {
        if (head == null) return;

        displayReverse(head.next);
        System.out.print(head.data + " -> ");
    }

    //count + Display
    public static void displayWithCount(Node head) {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;
        }

        System.out.println("null");
        System.out.println("Size: " + count);
    }
}
