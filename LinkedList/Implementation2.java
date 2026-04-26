public class Implementation2 {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null; // null will point always to next
        }
    }

    public static class linkedlist {
        Node head = null;
        Node tail = null;
        int length = 0;

        void insertAtEnd(int val){
            Node temp = new Node(val);   //create a new node with value val

            if (head == null){
                head = temp;
            }else{
                tail.next = temp;   //first connect tail to temp
            }
            tail = temp;  //then assign temp to tail
            length++;
        }

        void insertAtHead(int val){
            Node temp = new Node(val);

            if (head == null){   //Empty list
                head = temp;
                tail = temp;

                //or head = tail = temp;

                //or insertAtEnd(val);
            }else{    //Non empty list
                temp.next = head;
                head = temp;
            }
            length++;
        }

        //insertAt(index, value);
        void insertAt(int idx, int val){
            Node newNode = new Node(val);

            if (idx == size()){
                insertAtEnd(val);
                return;
            }else if (idx == 0){
                insertAtHead(val);
                return;
            }else if (idx < 0 || idx > size()){
                System.out.println("Wrong index");
                return;
            }

            Node temp = head;
            for (int i = 1; i <= idx-1; i++){
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }

        void deleteAt(int idx) {
            if (head == null) return;

            // Case 1: delete head
            if (idx == 0) {
                head = head.next;
                if (head == null) tail = null; // list became empty
                length--;
                return;
            }

            Node temp = head;

            // move to (idx - 1)
            for (int i = 0; i < idx - 1; i++) {
                if (temp.next == null) return; // invalid index
                temp = temp.next;
            }

            // node to delete doesn't exist
            if (temp.next == null) return;

            // if deleting last node → update tail
            if (temp.next == tail) {
                tail = temp;
            }

            temp.next = temp.next.next;
            length--;
        }

        void display(){
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "  ");
                temp = temp.next;
            }
            System.out.println();
        }

        int size(){
            Node temp = head;
            int count = 0;

            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        int getAt(int idx){
            Node temp = head;

            if (idx < 0 || idx > size()){
                System.out.println("Wrong index");
                return -1;
            }

            for (int i = 1; i <= idx; i++){
                temp = temp.next;
            }

            return temp.data;
        }
    }



    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.insertAtEnd(5);
        //ll.display();
        ll.insertAtEnd(7);
        //ll.display();
        ll.insertAtEnd(4);
        //ll.display();
        ll.insertAtEnd(2);
        //ll.display();
        ll.insertAtHead(1);
        //ll.display();
      //  ll.insertAt(0 ,10);  //insert at any index
        ll.display();
        //System.out.println(ll.tail.data);

        ll.deleteAt(0);
        ll.display();

        System.out.println(ll.getAt(0));
        System.out.println( "Size of LinkedList is: " + ll.size());
    }
}
