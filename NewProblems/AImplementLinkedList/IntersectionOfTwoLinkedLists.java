public class IntersectionOfTwoLinkedLists {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static Node FindIntersectionNode(Node headA, Node headB){
        int n1 = size(headA);
        int n2 = size(headB);

        Node a = headA;
        Node b = headB;

        if (n1 > n2){
            for (int i = 1; i <= n1-n2; i++){
                a = a.next;
            }
        }else{
            for (int i = 1; i <= n2-n1; i++){
                b = b.next;
            }
        }

        while (a != null && b != null){
            if (a == b) return a;

            a = a.next;
            b = b.next;
        }

        return null;
    }

    public static int size(Node head){
        Node temp = head;
        int count = 0;

        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
