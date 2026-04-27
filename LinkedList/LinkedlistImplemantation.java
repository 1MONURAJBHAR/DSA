//1. Traversal
//2. Insert (basic)
//3. Delete (basic)
//4. Reverse Linked List ⭐
//5. Find Middle ⭐
//6. Nth from end
//7. Detect cycle

public class LinkedlistImplemantation {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Delete a node by value
    public void delete(int key) {
        if (head == null) return;

        // If head is to be deleted
        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }

    // Display the list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedlistImplemantation list = new LinkedlistImplemantation();

        list.insertAtBeginning(10);
        list.insertAtBeginning(5);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("Linked List:");
        list.display();

        list.delete(20);
        System.out.println("After deleting 20:");
        list.display();
    }
}