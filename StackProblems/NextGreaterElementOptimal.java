import java.util.*;

public class NextGreaterElementOptimal {

    public static int[] nge(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        // traverse from right
        for (int i = n - 1; i >= 0; i--) {

            // pop smaller or equal elements
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // assign result
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            // push current element
            st.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};
        int[] ans = nge(arr);

        System.out.println(Arrays.toString(ans));
    }
}