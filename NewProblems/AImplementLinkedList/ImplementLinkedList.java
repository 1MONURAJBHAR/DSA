public class ImplementLinkedList {
    //user defined data type Node
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

   public static class linkedList{
        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtEnd(int data){
            Node temp = new Node(data);
            if (head == null){
                head = temp;
            }else{
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        void insertAtBegining(int data){
            Node temp = new Node(data);

            if (head == null){
                head = temp;
                tail = temp;
            }else{
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        int size(){
//            Node temp = head;
//            int count = 0;
//            while(temp != null){
//                count++;
//                temp = temp.next;
//            }
//            return count;

            //OR

            return size;
        }

       void deleteAt(int idx) {
           if (idx < 0 || idx >= size) {
               throw new IndexOutOfBoundsException();
           }

           // Delete head
           if (idx == 0) {
               head = head.next;
               size--;

               if (size == 0) {
                   tail = null;
               }
               return;
           }

           Node temp = head;

           // Reach node before the one to delete
           for (int i = 1; i < idx; i++) {
               temp = temp.next;
           }

           // Delete node
           temp.next = temp.next.next;

           // If deleting the last node, update tail
           if (idx == size - 1) {
               tail = temp;
           }

           size--;
       }

       void insertAt(int idx, int val) {
           Node t = new Node(val);
           Node temp = head;

           if (idx == size()) {
               insertAtEnd(val);
               return;
           }
           else if (idx == 0) {
               insertAtBegining(val);
               return;
           } else if (idx < 0 && idx > size()) {
               System.out.println("Wrong index");
               return;
           }

           for (int i = 1; i <= idx - 1; i++) {
               temp = temp.next;
           }

           t.next = temp.next;
           temp.next = t;

           size++;
       }

       int getAt(int idx){

            if (idx < 0 || idx > size()){
                System.out.println("Wrong index");
                return -1;
            }

            Node temp = head;

            for (int i = 1; i <= idx; i++){
                temp = temp.next;
            }

            return temp.data;
       }
   }



    public static void main(String[] args) {
        linkedList ll = new linkedList();

        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);

        ll.insertAtBegining(1);

        ll.display();
        System.out.println();
        System.out.println("Size of linked list is: "+ll.size());
        System.out.println(ll.getAt(0));
    }

}
