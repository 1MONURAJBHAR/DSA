public class IntersectionOfTwoLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find size of linked list
    public static int size(Node head) {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Find intersection node
    public static Node getIntersection(Node headA, Node headB) {
        int n1 = size(headA);
        int n2 = size(headB);

        Node a = headA;
        Node b = headB;

        // Align both lists
        if (n1 > n2) {
            for (int i = 0; i < n1 - n2; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < n2 - n1; i++) {
                b = b.next;
            }
        }

        // Traverse together
        while (a != null && b != null) {
            if (a == b) return a; // compare reference
            a = a.next;
            b = b.next;
        }

        return null;
    }

    public static void main(String[] args) {

        // Common part (intersection)
        Node common = new Node(30);
        common.next = new Node(40);
        common.next.next = new Node(50);

        // List A: 10 -> 20 -> 30 -> 40 -> 50
        Node headA = new Node(10);
        headA.next = new Node(20);
        headA.next.next = common;

        // List B: 5 -> 15 -> 30 -> 40 -> 50
        Node headB = new Node(5);
        headB.next = new Node(15);
        headB.next.next = common;

        Node intersection = getIntersection(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.data);
        } else {
            System.out.println("No intersection");
        }
    }
}