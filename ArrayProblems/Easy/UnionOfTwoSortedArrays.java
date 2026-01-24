import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,3,4,4,5,6};
        int[] arr = findUnion(num1, num2);
        System.out.println("Union of two arrays is: "+Arrays.toString(arr));
    }

    //Bruteforce approach, T.C: 3forLoops => O(n1log(n) + n2log(n))+O(n1+n2), S.C:(set + result array)-->O(n1+n2)+O(n1+n2)

    /**
     * Finds the union of two arrays.
     * Union means: all unique elements from both arrays.
     *
     * Using TreeSet:
     * - Removes duplicates automatically
     * - Stores elements in sorted order automatically
     */
    static int[] findUnion(int[] num1, int[] num2) {

        // TreeSet stores only unique values and keeps them sorted
        Set<Integer> temp = new TreeSet<>();

        // Add all elements of first array into the set
        // Duplicate elements will be ignored automatically
        for (int k : num1) {
            temp.add(k);
        }

        // Add all elements of second array into the set
        // Again, duplicates will be ignored
        for (int j : num2) {
            temp.add(j);
        }

        // Convert the set into an integer array (final answer)
        int[] result = new int[temp.size()];

        // Index to insert elements into result array
        int i = 0;

        // Copy elements from TreeSet into result array
        // TreeSet iteration gives sorted unique elements
        for (int num : temp) {
            result[i++] = num;
        }

        // Return the union array
        return result;
    }


     /* static int[] findUnion(int[] num1, int[] num2){
        Set<Integer> temp = new TreeSet<>();

        for (int k : num1) {
            temp.add(k);
        }
        for (int j : num2) {
            temp.add(j);
        }

        //using this array it to return answer
        int[] result = new int[temp.size()];
        int i = 0;
        for (int num: temp){
            result[i++] = num;
        }
        return result;
    }*/
}
