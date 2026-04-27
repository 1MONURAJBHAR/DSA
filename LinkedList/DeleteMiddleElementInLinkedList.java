public class DeleteMiddleElementInLinkedList {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to delete middle node
    public static ListNode deleteMiddle(ListNode head) {

        // Edge case: 0 or 1 node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find middle using slow-fast pointer
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete middle node
        prev.next = slow.next;

        return head;
    }

    // Utility: Insert at end
    public static ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) return newNode;

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Utility: Print list
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = null;

        // Creating list: 1 -> 2 -> 3 -> 4 -> 5
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);

        System.out.print("Original List: ");
        printList(head);

        head = deleteMiddle(head);

        System.out.print("After Deleting Middle: ");
        printList(head);
    }
}