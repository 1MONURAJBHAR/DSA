public class DoubleCircularLinkedList {

    static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    //This topic is not that much important, if you have time then do it

    // ----------------------------------
    // Insert at Head
    // ----------------------------------
    public static Node insertAtHead(Node head, int val) {
        Node newNode = new Node(val);

        // Empty list
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }

        Node tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;

        tail.next = newNode;
        head.prev = newNode;

        return newNode; // new head
    }

    // ----------------------------------
    // Insert at Tail
    // ----------------------------------
    public static Node insertAtTail(Node head, int val) {
        Node newNode = new Node(val);

        // Empty list
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }

        Node tail = head.prev;

        tail.next = newNode;
        newNode.prev = tail;

        newNode.next = head;
        head.prev = newNode;

        return head;
    }

    // ----------------------------------
    // Insert at Index
    // ----------------------------------
    public static Node insertAtIndex(Node head, int index, int val) {
        if (index == 0) return insertAtHead(head, val);

        Node temp = head;
        int i = 0;

        while (i < index - 1) {
            temp = temp.next;
            i++;

            if (temp == head) {
                System.out.println("Index out of bounds");
                return head;
            }
        }

        Node newNode = new Node(val);
        Node r = temp.next;

        temp.next = newNode;
        newNode.prev = temp;

        newNode.next = r;
        r.prev = newNode;

        return head;
    }

    // ----------------------------------
    // Delete Head
    // ----------------------------------
    public static Node deleteHead(Node head) {

        if (head == null) return null;

        // Single node
        if (head.next == head) return null;

        Node tail = head.prev;
        Node newHead = head.next;

        tail.next = newHead;
        newHead.prev = tail;

        return newHead;
    }

    // ----------------------------------
    // Delete Tail
    // ----------------------------------
    public static Node deleteTail(Node head) {

        if (head == null) return null;

        // Single node
        if (head.next == head) return null;

        Node tail = head.prev;
        Node newTail = tail.prev;

        newTail.next = head;
        head.prev = newTail;

        return head;
    }

    // ----------------------------------
    // Delete at Index
    // ----------------------------------
    public static Node deleteAtIndex(Node head, int index) {

        if (head == null) return null;

        if (index == 0) return deleteHead(head);

        Node temp = head;
        int i = 0;

        while (i < index) {
            temp = temp.next;
            i++;

            if (temp == head) {
                System.out.println("Index out of bounds");
                return head;
            }
        }

        Node prev = temp.prev;
        Node next = temp.next;

        prev.next = next;
        next.prev = prev;

        return head;
    }

    // ----------------------------------
    // Display Forward
    // ----------------------------------
    public static void displayForward(Node head) {
        if (head == null) return;

        Node temp = head;

        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // ----------------------------------
    // Display Backward
    // ----------------------------------
    public static void displayBackward(Node head) {
        if (head == null) return;

        Node tail = head.prev;
        Node temp = tail;

        do {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        } while (temp != tail);

        System.out.println();
    }

    // ----------------------------------
    // Main
    // ----------------------------------
    public static void main(String[] args) {

        Node head = null;

        head = insertAtHead(head, 10);
        head = insertAtHead(head, 20);
        head = insertAtTail(head, 30);
        head = insertAtTail(head, 40);

        displayForward(head);   // 20 10 30 40
        displayBackward(head);  // 40 30 10 20

        head = insertAtIndex(head, 2, 99);
        displayForward(head);   // 20 10 99 30 40

        head = deleteHead(head);
        displayForward(head);

        head = deleteTail(head);
        displayForward(head);

        head = deleteAtIndex(head, 1);
        displayForward(head);
    }
}