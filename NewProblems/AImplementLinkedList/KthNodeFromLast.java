public class KthNodeFromLast {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static Node getKthFromLast(Node head, int k){
        Node fast = head;
        Node slow = head;

        for (int i = 1; i <= k; i++){
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
