public class DeleteNthNodeFromEnd {
    public static class Node{
        int data;
        KthNodeFromLast.Node next;
        Node(int data){
            this.data = data;
        }
    }

    public int getKthFromLast(Node head, int k) {
        /*Node fast = head;
          Node slow = head;

          // Move fast k nodes ahead
          for (int i = 0; i < k; i++) {
              if (fast == null) {
                  return -1; // invalid k
              }
              fast = fast.next;
          }

          // Move both pointers
          while (fast != null) {
              slow = slow.next;
              fast = fast.next;
          }

          return slow.data;*/

        //OR

        // code here
        int m = size(head);

        if(k > m) return -1;

        Node temp = head;

        for(int i = 1; i < (m-k+1); i++){
            temp = temp.next;
        }

        return temp.data;
    }

    //Returns the length of linkedlist
    int size(Node head){
        int count = 0;
        Node temp = head;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }
}
