public class FindCycleInLinkedList {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Floyd’s Cycle Detection Algorithm
    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 and fast by 2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If they meet → cycle exists
            if (slow == fast) {
                return true;
            }
        }

        return false;
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

    // Utility: Create cycle at given position (0-based index)
    public static void createCycle(ListNode head, int pos) {
        if (pos == -1) return;

        ListNode temp = head;
        ListNode cycleNode = null;
        int index = 0;

        while (temp.next != null) {
            if (index == pos) {
                cycleNode = temp;
            }
            temp = temp.next;
            index++;
        }

        // connect last node to cycleNode
        temp.next = cycleNode;
    }

    // Safe print (prints limited nodes to avoid infinite loop)
    public static void printList(ListNode head, int limit) {
        ListNode temp = head;
        int count = 0;

        while (temp != null && count < limit) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
            count++;
        }
        System.out.println("...");
    }

    public static void main(String[] args) {

        ListNode head = null;

        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);

        // Create cycle (connect last node to index 2 → value 3)
        createCycle(head, 2);

        // Detect cycle
        if (hasCycle(head)) {
            System.out.println("Cycle detected in linked list");
        } else {
            System.out.println("No cycle found");
        }
    }
}