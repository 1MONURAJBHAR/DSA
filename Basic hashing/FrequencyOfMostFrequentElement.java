import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOfMostFrequentElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        System.out.println("Enter array elements: ");
        int[] arr = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Find highest occurring element (tie -> smallest)
        int ans = Integer.MAX_VALUE;
        int maxFreq = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                ans = num;
            } else if (freq == maxFreq && num < ans) {
                ans = num;
            }
        }

        System.out.println("Highest Occurring Element: " + ans);

        sc.close();
    }
}
