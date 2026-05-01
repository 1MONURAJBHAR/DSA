public class ArrayImplementationOfStack {
    public static class Stack{
//        private int[] arr = new int[5];
//        private int idx = 0;

        private int[] arr;
        private int idx;

        // constructor
        public Stack(int capacity) {
            arr = new int[capacity];
            idx = 0;
        }

        //push function
        void push(int x){
            if (isFull()){
                System.out.println("Stack is full!");
                return;
            }
            arr[idx] = x;
            idx++;
        }

        //peek function
        int peek(){
            if (idx == 0){
                System.out.println("Stack is Empty!");
                return -1;
            }

            return arr[idx-1];
        }

        //pop function
        int pop(){
            if (idx == 0){
                System.out.println("Stack is Empty!");
                return -1;
            }

            int top = arr[idx-1];
            arr[idx-1] = 0;
            idx--;
            return top;
        }

        void display(){
            ///Bottom → Top
            for (int i = 0; i <= idx - 1; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        int size(){
            return idx;
        }

        boolean isEmpty(){
            return idx == 0;
        }

        boolean isFull(){
            return idx == arr.length;
        }

        int capacity(){
            return arr.length;
        }


        /*

//        Returning -1 on error
//        This is not safe because -1 could be a valid value.
//        Better approach:
//        Throw exception: throw new RuntimeException("Stack is Empty");


          void push(int x) {
            if (isFull()) {
                throw new RuntimeException("Stack Overflow");
            }
            arr[idx++] = x;
        }

        int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack Underflow");
            }
            return arr[idx - 1];
        }

        int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack Underflow");
            }
            return arr[--idx];
        }

        void display() {
            // Top to Bottom (better)
            for (int i = idx - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        int size() {
            return idx;
        }

        boolean isEmpty() {
            return idx == 0;
        }

        boolean isFull() {
            return idx == arr.length;
        }

        int capacity() {
            return arr.length;
        }
        * */




    }




    public static void main(String[] args) {
         Stack st = new Stack(5);
         st.push(5);
         st.push(4);
         st.push(3);
         st.push(2);
         st.push(1);

         st.display();
        System.out.println("Size is: "+st.size());

        st.pop();
        st.display();
        System.out.println("Size is: "+st.size());

        int x = st.peek();
        System.out.println("Peek is: "+x);

    }
}
