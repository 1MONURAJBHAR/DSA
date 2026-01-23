import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapIntegerFrequencyTreeMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int n = sc.nextInt();

        System.out.println("Enter array elements: ");
        int[] arr = new int[n];
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // Pre-computation of map values (frequency)
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++){
            /*map.put(arr[i], newCount),Finally it stores updated count back in map.*/
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //iterate the key:value pairs of map,entrySet() --> gives you a set of all entries (pairs) in the map.
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("Enter the number of queries: ");
        int q = sc.nextInt();

        while(q-- > 0){
            System.out.print("Enter number to find frequency: ");
            int n1 = sc.nextInt();

            System.out.println("Frequency of number is: "+map.getOrDefault(n1,0));
        }
        sc.close();



    }

}
