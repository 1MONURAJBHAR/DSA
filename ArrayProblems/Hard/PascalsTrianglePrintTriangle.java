import java.util.ArrayList;
import java.util.List;

public class PascalsTrianglePrintTriangle {
    public static void main(String[] args) {

//        List<List<Integer>> result = PascalsTriangle(6);
        List<List<Long>> result = PascalsTriangleOptimal(6);

        /*for (int i = 0; i < ans.size(); i++) {
         for (int j = 0; j < ans.get(i).size(); j++) {
            System.out.print(ans.get(i).get(j) + " ");
         }
          System.out.println(); // Move to next row
        }
      */

        for (List<Long> row : result) {
            for (long num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
//        System.out.println(result);
    }

    // T.C: O(n^2), S.C: O(1) & O(n^2) (for storing triangle)
    static List<List<Long>> PascalsTriangleOptimal(int n){
        List<List<Long>> list = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            List<Long> ans = PrintNthRowOptimal(i);
            list.add(ans);
        }
        return list;
    }

    static List<Long> PrintNthRowOptimal(int n){

        List<Long> list = new ArrayList<>();

        long ans = 1;

        // First element always 1
        list.add(ans);

        for (int c = 1; c < n; c++){
            ans = ans * (n - c);
            ans = ans / c;
            list.add(ans);
        }

        return list;
    }













    //Brute T.C:(n^3), S.C: O(1) & O(n^2) (for storing triangle)
    static List<List<Integer>> PascalsTriangle(int n){
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            List<Integer> currRow = new ArrayList<>();
            for (int j = 1; j <= i; j++){
                currRow.add(nCr(i-1,j-1));
            }
            ans.add(currRow);
        }
        return ans;
    }

    static int nCr(int n, int r){
        int res = 1;
        for (int i = 0; i < r; i++){
            res = res*(n-i);
            res = res/(i+1);
        }
        return res;
    }
}
