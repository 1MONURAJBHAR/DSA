import java.util.ArrayList;
import java.util.List;

public class PascalsTrianglePrintNthRow {
    public static void main(String[] args) {
        List<Long> ans = PrintNthRowOptimal(6);
        System.out.println("Row: "+ ans);
    }

    //T.C:O(n), S.C:O(1)
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



    //T.C:O(n*r), S.C:O(1)
    static List<Integer> PrintNthRow(int n){
        List<Integer> ans = new ArrayList<>();
        for (int c = 1; c <= n; c++){
            int element = nCr(n-1,c-1);
            ans.add(element);
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
