import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindNumberAppearsOnceUsingMaps {
    public static void main(String[] args) {
        int[] arr = {1,1,5,6,6,5,7};
        int ans = FindNumberUsingHashMap(arr);
        System.out.println(ans);
    }

    //Unordered Map, T.C--> O(n) or O(n+(n/2)+1),  S.C:O(n) or O((n/2)+1)
    static int FindNumberUsingHashMap(int[] arr){
        // Map to store frequency of each number
        Map<Integer,Integer> map = new HashMap<>();

        // Count frequency of every element
        for (int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // Find the element whose frequency is 1
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){  //run for O((n/2)+1)
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }

        // If no element appears once
        return -1;
    }



    //T.C-->O(n log n) or O(n log((n/2)+1)),   S.C:O(n) or O((n/2)+1)
    //Returns the smallest unique element (because TreeMap is sorted)
    static int findNumberUsingTreeMap(int[] arr) {

        // TreeMap stores keys in sorted order (ascending)
        Map<Integer, Integer> freq = new TreeMap<>();

        // Count frequency of each element
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Find the number that appears exactly once
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {  //run for O((n/2)+1)
            if (entry.getValue() == 1) {
                return entry.getKey(); // smallest unique element (because TreeMap is sorted)
            }
        }

        return -1; // no unique element found
    }


}
