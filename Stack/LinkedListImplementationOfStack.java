public class LinkedListImplementationOfStack {
    public static class Node{   //user defined data type
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    public static class Stack{   //user defined data structure
        private Node head = null;
        private int size = 0;

        void push(int val){
            Node newNode = new Node(val);

            newNode.next = head;
            head = newNode;

            size++;
        }

        int peek(){
            if (head == null){
                System.out.println("Stack is empty!");
                return -1;
            }

            return head.val;
        }

        int pop(){
            if (head == null){
                System.out.println("Stack is empty!");
                return -1;
            }

            int val = head.val;
            head = head.next;
            size--;
            return val;
        }

        //top->bottom
        void displayRev(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.val+ " ");
                temp = temp.next;
            }
            System.out.println();
        }

        //Print in reverse order (because recursion goes deep first)  Bottom -> Top
        void displayRecursive(Node head1){
            if (head1 == null) return;

            displayRecursive(head1.next);
            System.out.print(head1.val + " ");
        }

        //normal order (same as iterative)  Top -> bottom
        void displayRecursive2(Node head1){
            if (head1 == null) return;

            System.out.print(head1.val + " ");
            displayRecursive(head1.next);
        }

        void display(){
            displayRecursive(head);
            System.out.println();
        }

        boolean isEmpty(){
            return size == 0;
        }

        int size(){  //getter
            return size;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);

        st.display();
        System.out.println("Is empty : "+st.isEmpty());

        System.out.println("Peek : "+st.peek());
        System.out.println("Pop : "+st.pop());
        System.out.println("Peek : "+st.peek());
        st.display();
        System.out.println("Size: "+ st.size());
    }
}
