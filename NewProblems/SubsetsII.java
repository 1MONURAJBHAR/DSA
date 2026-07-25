import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
    public ArrayList<ArrayList<Integer>> AllSubsets(int arr[]) {
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        backtrack(0, arr, curr, ans);

        return ans;
    }

    public static void backtrack(int index, int[] arr, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(curr));

        for(int i = index; i < arr.length; i++){
            if (i > index && arr[i] == arr[i-1]){
                continue;
            }

            curr.add(arr[i]);

            backtrack(i+1, arr, curr, ans);

            // curr.remove((curr.size() - 1));
            curr.removeLast();
        }
    }
}
