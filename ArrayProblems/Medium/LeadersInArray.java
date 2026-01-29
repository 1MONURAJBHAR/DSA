import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
//        List<Integer> ans = Leaders(arr);
        List<Integer> ans = Leaders2(arr);
//        Collections.reverse(ans);  //applicable to only lists
        System.out.println(ans);
    }


    //T.C: O(n)+O(n log(n)), S.C: O(n)
    static List<Integer> Leaders2(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();  //O(n) only to store the result

        for (int i = n-1; i>=0; i--){  //O(n)
            if (arr[i] > max){
                list.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.sort(list);  //O(n log(n))
        return list;
    }

    //T.C: approx O(n^2), S.C:O(n)--> to store the ans
    static List<Integer> Leaders(int[] arr){
        int n = arr.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            boolean leader = true;
            for (int j = i + 1; j < n; j++){
                if (arr[j] > arr[i]){
                    leader = false;
                    break;
                }
            }
            if (leader){
                list.add(arr[i]);
            }
        }
        return list;
    }
}
