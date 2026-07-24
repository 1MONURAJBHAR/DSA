import java.util.ArrayList;

public class Subsets {
    public static ArrayList<ArrayList<Integer>> subsets(int[] arr){

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();

        backtrack(0, arr, curr, ans);

        return ans;
    }

    public static void backtrack(int index, int[] arr, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(curr));

        for (int i = index; i < arr.length; i++){
            curr.add(arr[i]);

            backtrack(i+1,arr,curr,ans);

            curr.remove((curr.size() - 1));
        }
    }

}
