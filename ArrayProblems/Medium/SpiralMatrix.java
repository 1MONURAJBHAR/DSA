import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer>list =  spiralOrder(arr);
        System.out.println(list);

    }


    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        while(top<=bottom && left<=right){
            //traverse the top row
            for(int i = left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            //traverse the right column
            for(int j = top; j<=bottom; j++){
                result.add(matrix[j][right]);
            }
            right--;

            //traverse the bottom row
            if(top<=bottom){
                for(int i = right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //traverse the left column
            if(left<=right){
                for(int j = bottom; j>=top; j--){
                    result.add(matrix[j][left]);
                }
                left++;
            }
        }
        return result;
    }
}
