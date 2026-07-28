import java.util.List;

public class diagonalDifferenceHackerank {
    public static int diagonalDifference(List<List<Integer>> arr) {

        int n = arr.size();

        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < n; i++) {
            primary += arr.get(i).get(i);
            secondary += arr.get(i).get(n - 1 - i);
        }

//        for array:
//        for (int i = 0; i < n; i++) {
//            primary += arr[i][i];
//            secondary += arr[i][n - 1 - i];
//        }


        return Math.abs(primary - secondary);
    }
}
