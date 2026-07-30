import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfPushesToTypeWordI {

    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;

        for (int i = 0; i < n; i++) {
            pushes += (i / 8) + 1;
        }

        return pushes;
    }

    /*public int minimumPushes2(String word) {
        int result = 0;

        // key -> number of letters assigned
        Map<Integer, Integer> map = new HashMap<>();

        int assignKey = 2;

        for (char ch : word.toCharArray()) {

            if (assignKey > 9) {
                assignKey = 2;
            }

            map.put(assignKey, map.getOrDefault(assignKey, 0) + 1);

            result += map.get(assignKey);

            assignKey++;
        }

        return result;
    }*/

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordI obj = new MinimumNumberOfPushesToTypeWordI();

        System.out.println(obj.minimumPushes("abcde"));      // 5
        System.out.println(obj.minimumPushes("xycdefghij"));  // 12
    }
}