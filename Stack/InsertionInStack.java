import java.util.Stack;

public class InsertionInStack {

    // Insert value at given index (0-based from bottom)
    public static void insertAtIndex(Stack<Integer> st, int idx, int val) {
        // Edge case
        if (idx < 0 || idx > st.size()) {
            System.out.println("Invalid index");
            return;
        }

        Stack<Integer> temp = new Stack<>();

        // Move elements until we reach index
        while (st.size() > idx) {
            temp.push(st.pop());
        }

        // Insert element
        st.push(val);

        // Restore stack
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    //recursive approach
    public static void insertAtIndexRec(Stack<Integer> st, int idx, int val) {
        if (st.size() == idx) {
            st.push(val);
            return;
        }

        int top = st.pop();
        insertAtIndexRec(st, idx, val);
        st.push(top);
    }

    public static void insertAtBottom(Stack<Integer> st, int val){
        Stack<Integer> gt = new Stack<>();

        while(st.size() > 0){
            gt.push(st.pop());
        }
        st.push(val);

        while (gt.size() > 0){
            st.push(gt.pop());
        }
    }


    public static void insertAtBottom2(Stack<Integer> st, int val) {
        Stack<Integer> temp = new Stack<>();

        // Move all elements to temp
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        // Insert at bottom
        st.push(val);

        // Restore elements
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    public static void insertAtBottomRec(Stack<Integer> st, int val) {
        if (st.isEmpty()){
            st.push(val);
            return;
        }
        int top = st.pop();
        insertAtBottom(st,val);
        st.push(top);
    }

    static void deleteFromBottom(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>();

        while(st.size() > 1){
            rt.push(st.pop());
        }
        st.pop();

        while(!rt.isEmpty()){
            st.push(rt.pop());
        }
    }

    static void deleteFromAnyIdx(Stack<Integer> st, int idx){
        Stack<Integer> rt = new Stack<>();

        while(st.size() > idx){
            rt.push(st.pop());
        }
        st.pop();

        while(!rt.isEmpty()){
            st.push(rt.pop());
        }
    }

    // Delete element at given index (0-based from bottom)
    public static void deleteAtIndex(Stack<Integer> st, int idx) {
        if (idx < 0 || idx >= st.size()) {
            System.out.println("Invalid index");
            return;
        }

        Stack<Integer> temp = new Stack<>();

        // Move elements above idx
        while (st.size() > idx + 1) {
            temp.push(st.pop());
        }

        // Remove target element
        st.pop();

        // Restore stack
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println("Original Stack: " + st);

//        insertAtIndex(st, 2, 7);
//        System.out.println("After Insertion: " + st);

//        insertAtBottom(st, 7);
//        insertAtBottomRec(st,8);
//        deleteFromBottom(st);
        deleteAtIndex(st,1);
        System.out.println("After Insertion at bottom: " + st);

    }
}