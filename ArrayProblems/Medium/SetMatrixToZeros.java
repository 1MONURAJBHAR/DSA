public class SetMatrixToZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
//        SetMatrix(matrix);
//        SetMatrixBetter(matrix);
        setMatrixOptimal(matrix);
        printMatrix(matrix);
    }


    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }*/

    static void setMatrixOptimal(int[][] matrix) {
        int n = matrix.length;        // number of rows
        int m = matrix[0].length;     // number of columns

        int col0 = 1;                 // flag to track whether first column should be zero

        // Use first row and first column as markers
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;     // mark the current row

                    if (col != 0) {
                        matrix[0][col] = 0; // mark the current column
                    } else {
                        col0 = 0;           // mark first column separately
                    }
                }
            }
        }

        // Set matrix elements to zero based on markers
        // (excluding first row and first column)
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Handle the first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle the first column
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    //T.C:O(2*m*n), S.C:O(n)+O(m)
    static void SetMatrixBetter(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        // mark rows and columns
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (arr[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // set matrix to zero
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(row[i] == 1 || col[j] == 1){
                    arr[i][j] = 0;
                }
            }
        }
    }






    //T.C:O(n*m)*O(n+m)+O(n*m) == O(n^3)
    static void SetMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        // mark rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    markRow(arr, i);
                    markColumn(arr, j);
                }
            }
        }

        // convert -1 to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void markRow(int[][] arr, int row) {
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j] != 0) {
                arr[row][j] = -1;
            }
        }
    }

    static void markColumn(int[][] arr, int col) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] != 0) {
                arr[i][col] = -1;
            }
        }
    }
}
