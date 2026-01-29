public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
//      int[][] ans = RotateMatrix(arr);
      RotateMatrixOptimal(arr);
      printMatrix(arr);
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //The transpose loop runs over the upper triangular part of the matrix, performing n(n−1)/2 swaps, which simplifies to O(n²).
    //T.C:O(n²), S.C:O(1)(in-place rotation)
    static void RotateMatrixOptimal(int[][] arr){
        int n = arr.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++){
            int left = 0, right = n-1;

            while(left < right){
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }


    //T.C:O(n^2), S.C:O(n^2)
    static int[][] RotateMatrix(int[][] arr){
        int n = arr.length;
        int[][] ans  = new int[n][n];
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){
                ans[col][n-1-row] = arr[row][col];
            }
        }
        return ans;
    }


    /*static void RotateMatrix(int[][] arr) {
    int n = arr.length;
    int[][] temp = new int[n][n];

    for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
            temp[col][n - 1 - row] = arr[row][col];
        }
    }

    // copy back to original matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            arr[i][j] = temp[i][j];
        }
    }
}
*/
}
