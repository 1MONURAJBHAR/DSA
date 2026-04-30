public class SingleCircularLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // -------------------------------
    // Insert at Head
    // -------------------------------
    public static Node insertAtHead(Node head, int val) {
        Node newNode = new Node(val);

        // Empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node tail = head;

        // Find tail
        while (tail.next != head) {
            tail = tail.next;
        }

        newNode.next = head;
        tail.next = newNode;

        return newNode; // new head
    }

    // -------------------------------
    // Insert at Tail
    // -------------------------------
    public static Node insertAtTail(Node head, int val) {
        Node newNode = new Node(val);

        // Empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node tail = head;

        while (tail.next != head) {
            tail = tail.next;
        }

        tail.next = newNode;
        newNode.next = head;

        return head;
    }

    // -------------------------------
    // Display from Head
    // -------------------------------
    public static void displayFromHead(Node head) {
        if (head == null) return;

        Node temp = head;

        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // -------------------------------
    // Display from ANY Node
    // -------------------------------
    public static void displayFromAnyNode(Node node) {
        if (node == null) return;

        Node temp = node;

        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != node);

        System.out.println();
    }

//    Delete Head
// Steps:
//    Find tail
//    Move head forward
//    Fix tail.next
    public static Node deleteHead(Node head) {

        // Empty list
        if (head == null) return null;

        // Single node
        if (head.next == head) return null;

        Node tail = head;

        // Find tail
        while (tail.next != head) {
            tail = tail.next;
        }

        // Move head
        Node newHead = head.next;

        // Fix circular link
        tail.next = newHead;

        return newHead;
    }

//    2. Delete Tail
// Steps:
//    Traverse to second last node
//    Remove last node
//    Fix link to head
    public static Node deleteTail(Node head) {

        // Empty list
        if (head == null) return null;

        // Single node
        if (head.next == head) return null;

        Node temp = head;

        // Reach second last node
        while (temp.next.next != head) {
            temp = temp.next;
        }

        // Remove tail
        temp.next = head;

        return head;
    }

//    Delete at Index
// Uses 2-pointer logic (prev + curr)
    public static Node deleteAtIndex(Node head, int index) {

        // Empty list
        if (head == null) return null;

        // Delete head
        if (index == 0) {
            return deleteHead(head);
        }

        Node prev = head;
        int i = 0;

        // Move to (index - 1)
        while (i < index - 1) {
            prev = prev.next;
            i++;

            // If we loop back → invalid index
            if (prev == head) {
                System.out.println("Index out of bounds");
                return head;
            }
        }

        Node curr = prev.next;

        // If deleting tail
        if (curr.next == head) {
            prev.next = head;
        } else {
            prev.next = curr.next;
        }

        return head;
    }

    // -------------------------------
    // Main (Testing)
    // -------------------------------
    public static void main(String[] args) {

        Node head = null;

        head = insertAtHead(head, 10);
        head = insertAtHead(head, 20);
        head = insertAtTail(head, 30);
        head = insertAtTail(head, 40);

        // List: 20 10 30 40 (circular)

        System.out.print("From Head: ");
        displayFromHead(head);

        // Take any node (example: head.next)
        Node randomNode = head.next;

        System.out.print("From Any Node: ");
        displayFromAnyNode(randomNode);
    }
}