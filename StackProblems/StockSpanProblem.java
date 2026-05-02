import java.util.*;

//concept: college wallah and shraddha khapra
//problem on GFG: name: Stack Span Problem

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(n);

        Stack<Integer> st = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {

            // pop all indices whose values are <= current value
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            // calculate span
            if (st.isEmpty()) {
                res.add(i + 1);
            } else {
                res.add(i - st.peek());
            }

            // push current index
            st.push(i);
        }

        return res;
    }
}

public class StockSpanProblem {
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] arr1 = {100, 80, 90, 120};
        int[] arr2 = {10, 4, 5, 90, 120, 80};

        ArrayList<Integer> result1 = obj.calculateSpan(arr1);
        ArrayList<Integer> result2 = obj.calculateSpan(arr2);

        System.out.println("Output 1: " + result1);
        System.out.println("Output 2: " + result2);
    }
}