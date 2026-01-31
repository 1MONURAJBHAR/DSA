import java.util.*;

public class MajorityElementsNBy3Times {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,2,2,2};
//        List<Integer> ans = MajorityElementN3(arr);
        List<Integer> ans = MajorityElementsNBy3TimesOptimal(arr);
        System.out.println(ans);
    }

    // T.C: O(n), S.C: O(1) -> Only few variables used, result list max size = 2
   static List<Integer> MajorityElementsNBy3TimesOptimal(int[] arr){
        int n = arr.length;

        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

         //Find potential candidates that could appear more than n/3 times
        for (int num: arr){
            // If count1 is zero -> assign new candidate
            // Also ensure it is not equal to second candidate
            if (count1 == 0 && num != element2){
                count1++;
                element1 = num;
            }
            else if (count2 == 0 && num != element1){  //vice versa as above comment.
                count2++;
                element2 = num;
            }
            // If matches candidates -> increase count
            else if (num == element1) count1 ++;
            else if (num == element2) count2++;
            else {      // If different from both -> cancel votes
                count1--;
                count2--;
            }
        }

        /*
        Count actual frequency of candidates
        Because voting only gives possible candidates*/

        int cnt1Freq = 0;
        int cnt2Freq = 0;

        for (int num: arr){
            if (num == element1) cnt1Freq++;
            else if (num == element2) cnt2Freq++;
        }

       // Result list (max size = 2)
       List<Integer> list = new ArrayList<>();

        int min = n/3+1;

        if (cnt1Freq >= min) list.add(element1);
        if (cnt2Freq >= min) list.add(element2);

       Collections.sort(list);
       return list;
    }










    // T.C: O(n) best & avg, for worst case: O(n^2), S.C: O(n)
    static List<Integer> MajorityElementN3Better(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;

        // Stores majority elements (max possible = 2)
        List<Integer> list = new ArrayList<>();
        int min = n/3+1; //floor value + 1, ex: 2+1 == 3
        for (int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
            if (map.get(num) == min){
                list.add(num);
            }
            if (list.size() == 2) break;
        }

        return list;
    }


    /*  static List<Integer> MajorityElementN3Better(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;

        // Stores majority elements (max possible = 2)
        List<Integer> list = new ArrayList<>();

        for (int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

       *//* for (int key: map.keySet()){  //get keys from map
            if (map.get(key) > n/3){  //get values of keys form map
                list.add(key);
            }
        }*//*

          //OR both are doing same work.

        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > n/3){
                list.add(key);
            }
        }

        return list;
    }*/




    // T.C: O(n^2), S.C: O(1) -> Because result list stores at most 2 elements only
    static List<Integer> MajorityElementN3(int[] arr){

        int n = arr.length;

        // Stores majority elements (max possible = 2)
        List<Integer> list = new ArrayList<>();

        // Pick each element as candidate
        for (int i = 0; i < n; i++){

        /*
         Avoid recounting if already stored.
         Only check if:
         - list empty OR
         - current element not equal to first stored majority element
        */
            if (list.isEmpty() || list.get(0) != arr[i]){

                int count = 0;

                // Count frequency of arr[i]
                for (int j = 0; j < n; j++){
                    if(arr[i] == arr[j]){
                        count++;
                    }
                }

                // If appears more than n/3 times -> majority element
                if (count > n/3){
                    list.add(arr[i]);
                }
            }

            // At most 2 elements can exist > n/3
            if (list.size() == 2) break;
        }

        return list;
    }


}
