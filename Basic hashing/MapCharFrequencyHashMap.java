import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapCharFrequencyHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sc.next();

        //T.C for storing and fetching elements from map takes O(1) for -> avg,best.

        // Pre-computation of map values (frequency)
        //HashMap --> unordered map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            /*map.put(arr[i], newCount),Finally it stores updated count back in map.*/
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        //iterate the key:value pairs of map,entrySet() --> gives you a set of all entries (pairs) in the map.
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("Enter the number of queries: ");
        int q = sc.nextInt();

        while(q-- > 0){
            System.out.print("Enter character to find frequency: ");
            char n1 = sc.next().charAt(0);

            System.out.println("Frequency of character is: "+map.getOrDefault(n1,0));
        }
        sc.close();
    }
}
