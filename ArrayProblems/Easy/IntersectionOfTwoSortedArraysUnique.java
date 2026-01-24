import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IntersectionOfTwoSortedArraysUnique {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4, 5};
        int[] b = {2, 2, 3, 3, 5, 6};

//        System.out.println(IntersectionBrute(a,b));
        System.out.println(IntersectionOptimal(a, b));
    }

    // T.C: O(n * m), S.C: O(k)
    static List<Integer> IntersectionBrute(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>(); // keeps result sorted

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    set.add(a[i]);
                    break;
                }
            }
        }
        return new ArrayList<>(set);
    }

    // T.C: O(n + m), S.C: O(k)
    static List<Integer> IntersectionOptimal(int[] a, int[] b) {
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                // add only if last added is not same (unique)
                if (ans.isEmpty() || ans.getLast() != a[i]) {
                    ans.add(a[i]);
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
