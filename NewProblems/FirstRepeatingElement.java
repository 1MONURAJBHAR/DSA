import java.util.HashSet;

public class FirstRepeatingElement {
    public static int firstRepeated(int[] arr){
        HashSet<Integer> set = new HashSet<>();

        int ans = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                ans = i + 1; // 1-based indexing
            } else {
                set.add(arr[i]);
            }
        }

        return ans;
    }
}
