import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
        List<List<Integer>> ans = MergeIntervals2(arr);
        System.out.println(ans);
    }

    //T.C:O(N log N), S.C:O(N)
    static List<List<Integer>> MergeIntervals2(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++){
            // If list is empty OR no overlap with last interval
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)){
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            //Overlapping interval --> merge
            else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;
    }

    //T.C:O(N log N), S.C:O(N)
    static List<List<Integer>> MergeIntervals(int[][] arr) {

        int n = arr.length;

      /* Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });*/
        // Sort intervals by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int start = arr[i][0];
            int end = arr[i][1];

            // Correct skip condition
            if (!ans.isEmpty() && start <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // Merge overlapping intervals
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
        }

        return ans;
    }

}
