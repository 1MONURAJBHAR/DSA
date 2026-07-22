import java.util.ArrayList;

public class MergeThreeArrays {
    public ArrayList<Integer> mergeThree(int[] a, int[] b, int[] c) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0, k = 0;
        int n = a.length, m = b.length, p = c.length;

        // Merge while all three arrays have elements
        while (i < n && j < m && k < p) {
            if (a[i] <= b[j] && a[i] <= c[k]) {
                ans.add(a[i++]);
            } else if (b[j] <= a[i] && b[j] <= c[k]) {
                ans.add(b[j++]);
            } else {
                ans.add(c[k++]);
            }
        }

        // Merge remaining of a and b
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                ans.add(a[i++]);
            } else {
                ans.add(b[j++]);
            }
        }

        // Merge remaining of b and c
        while (j < m && k < p) {
            if (b[j] <= c[k]) {
                ans.add(b[j++]);
            } else {
                ans.add(c[k++]);
            }
        }

        // Merge remaining of a and c
        while (i < n && k < p) {
            if (a[i] <= c[k]) {
                ans.add(a[i++]);
            } else {
                ans.add(c[k++]);
            }
        }

        // Add leftover elements
        while (i < n) ans.add(a[i++]);
        while (j < m) ans.add(b[j++]);
        while (k < p) ans.add(c[k++]);

        return ans;
    }
}
