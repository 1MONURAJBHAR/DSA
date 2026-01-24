import java.util.*;

public class UnionOfTwoSortedArraysOptimal {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,3,4,4,5,6};
        List<Integer> list =  findUnionOptimal(num1, num2);
        System.out.println("Union of two arrays is: "+ list);
    }


    //T.C: O(n1+n2), S.C: O(n1+n2) --> but using only for storing the result array, not using for solving the problem.

    static List<Integer> findUnionOptimal(int[] num1, int[] num2) {
       int n1 = num1.length;
       int n2 = num2.length;

        // Two pointers to traverse both arrays
       int i = 0;
       int j = 0;

       List<Integer> temp = new ArrayList<>();

        // traverse both arrays until one gets exhausted
       while(i < n1 && j < n2){
           // If current element in num1 is smaller/equal, consider it first
           if(num1[i] <= num2[j]){
               // Add only if it's not already present in result
               if(temp.isEmpty() || !temp.contains(num1[i])){
                   temp.add(num1[i]);
               }
               i++;
           }else{
               if(temp.isEmpty() || !temp.contains(num2[j])){
                   temp.add(num2[j]);
               }
               j++;
           }
       }

        // add remaining elements from num1 & num2 (if any):
       while(i < n1){
           if(temp.isEmpty() || !temp.contains(num1[i])){
               temp.add(num1[i]);
           }
           i++;
       }

       while(j < n2){
           if(temp.isEmpty() || !temp.contains(num2[j])){
               temp.add(num2[j]);
           }
           j++;
       }

       return temp;
    }

}
