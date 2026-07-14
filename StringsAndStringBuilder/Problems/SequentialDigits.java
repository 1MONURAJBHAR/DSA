import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for (int start = 1; start <= 9; start++) {
            int num = start;

            for (int next = start + 1; next <= 9; next++) {
                num = num * 10 + next;

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int low = 100;
        int high = 10000;

        List<Integer> result = sequentialDigits(low, high);

        System.out.println(result);
    }
}