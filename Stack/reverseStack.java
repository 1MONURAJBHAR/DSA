import java.util.Stack;

public class reverseStack {

    // Insert at bottom (helper)
    public static void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, val);
        st.push(top);
    }

    /*
    * | Method    | Time  | Space |
      | --------- | ----- | ----- |
      | Recursive | O(n²) | O(n)  |
      | Iterative | O(n)  | O(n)  |
    * */

    // Reverse stack using recursion
    public static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        reverse(st);                 // reverse remaining stack
        insertAtBottom(st, top);     // insert at bottom
    }

    public static Stack<Integer> reverseIterative(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        return temp; // THIS is reversed stack
    }

    //Time-> O^3, Space->O^2
    public static void reverseStackUsing3WhileLoop(Stack<Integer> st){
        System.out.println("Unreversed st : "+st);

        Stack<Integer> rt = new Stack<>();
        while (!st.isEmpty()){
            rt.push(st.pop());
        }
        System.out.println("1st reversed rt : "+rt);

        Stack<Integer> gt = new Stack<>();
        while (!rt.isEmpty()){
            gt.push(rt.pop());
        }
        System.out.println("2nd reversed gt : "+gt);

        while (!gt.isEmpty()){
            st.push(gt.pop());
        }
        System.out.println("Final reversed st : "+st);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

//        System.out.println("Original: " + st);
//
//        reverse(st);
//
//        System.out.println("Reversed: " + st);

        reverseStackUsing3WhileLoop(st);
    }
}