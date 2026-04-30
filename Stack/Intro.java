import java.util.Stack;

public class Intro {
    public static void main(String[] args) {
        //Also called LIFO or FILO
        Stack<Integer> st = new Stack<>();
//        System.out.println("Size is : " + st.size());
//        System.out.println(st);
        st.push(1);
        st.push(23);
        st.push(90);
        st.push(5);
        st.push(34);

        //peek
//        System.out.println(st.peek());
//        System.out.println(st);
//        st.pop();
//        System.out.println(st);
//        st.pop();
//        System.out.println(st);
//        System.out.println("Size is : "+st.size());

        //print first element
        while(st.size() > 1){
            st.pop();
        }
        System.out.println(st.peek());
    }
}
