import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArraysWithDuplicates {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,4,4,5};
        int[] num2 = {2,3,4,4,5,6};
//        List<Integer> list =  Intersection(num1, num2);
        List<Integer> list = IntersectionOptimal(num1, num2);
        System.out.println("Intersection of two arrays is: "+ list);
    }

    //T.C: O(n1+n2), S.C:O(n1+n2)
    static List<Integer> IntersectionOptimal(int[] num1, int[] num2){
        int n1 = num1.length;
        int n2 = num2.length;

        int i = 0, j = 0;
        List<Integer> temp = new ArrayList<>();

        while(i < n1 && j < n2){
            if (num1[i] == num2[j]){
                temp.add(num1[i]);
                i++;
                j++;
            }else if (num1[i] < num2[j]){
                i++;
            }else {
                j++;
            }
        }
        return temp;
    }

    //BruteForce approach       T.C: O(n1xn2) , S.C:O(n2)
    static List<Integer> Intersection(int[] num1, int[] num2) {
        boolean[] used = new boolean[num2.length];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {

                if (num1[i] == num2[j] && !used[j]) {
                    ans.add(num1[i]);
                    used[j] = true;
                    break;
                }

                // Since arrays are sorted, no need to check further
                if (num2[j] > num1[i]) break;
            }
        }
        return ans;
    }

}
