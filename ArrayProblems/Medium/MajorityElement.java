import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,1,2,2};
//        int ans = findMajority(arr);
//        int ans = findMajorityByHashing(arr);
        int ans = MajorityElementOptimal(arr);
        System.out.println("Majority element: "+ans);
    }

    static int MajorityElementOptimal(int[] arr){
        int n = arr.length;
        int candidate = 0;
        int count = 0;

        for (int num: arr){
            if (count == 0){
                candidate = num;
            }

            if (num == candidate) count++;
            else count--;
        }

        int freq = 0;
        for (int num: arr){
            if (num == candidate) freq++;
        }

        if (freq > n/2) return candidate;

        return -1;
    }

    //T.C: O(n) best&avg, for worst case: O(n^2), S.C:O(n)
    static int findMajorityByHashing(int[] arr){
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();

        for (int num: arr){
            int freq = map.getOrDefault(num,0)+1;
            map.put(num, freq);

            if (freq > n / 2) return num;
        }

        return -1;
    }

   /* static int findMajorityByHashing(int[] arr){
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();

        for (int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (entry.getValue()>n/2){
                return entry.getKey();
            }
        }
        return -1;
    }*/

    //T.C:O(n^2)  S.C:O(1)
    static int findMajority(int[] arr){
        int n = arr.length;

        for (int num1 : arr) {

            int count = 0;

            for (int num2 : arr) {

                if (num1 == num2) {
                    count++;
                }

            }

            if (count > n/2){
                return num1;
            }
        }
        return -1;
    }
}
