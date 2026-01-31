public class PascalsTrianglePrintElement {
    public static void main(String[] args) {
        long ans =   FindElementInPascalTriangle(5,3);
        System.out.println("Element at this position is: "+ans);
    }

    static long FindElementInPascalTriangle(int row, int col){
        //return nCr(row-1, col-1);
        return nCr2(row-1, col-1);
    }

    //T.C: O(r), S.C: O(1)
    static long nCr2(int n, int r){
        long res = 1;

        for(int i = 0; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    //T.C: O(n)+O(r)+O(n-r), S.C: O(1)
    //using factorial formula
   /* // nCr using factorial
    static long nCr(int row, int col){
        return fact(row)/(fact(col)*fact(row-col));
    }

    static long fact(int n){
        long res = 1;
        for (int i = 1; i <= n; i++){
            res = res*i;
        }
        return res;
    }*/

}
