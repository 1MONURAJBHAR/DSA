import java.util.Arrays;
import java.util.HashMap;

public class SortThePeople {

    public static String[] sortPeople(String[] names, int[] heights) {

        HashMap<Integer, String> map = new HashMap<>();

        // Store height -> name
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        // Create a copy so the original heights array is not modified
        int[] sortedHeights = heights.clone();

        Arrays.sort(sortedHeights);

        String[] ans = new String[names.length];
        int index = 0;

        // Traverse from largest to smallest height
        for (int i = sortedHeights.length - 1; i >= 0; i--) {
            ans[index++] = map.get(sortedHeights[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        System.out.println("Input Heights : " + Arrays.toString(heights));
        System.out.println("Input Names   : " + Arrays.toString(names));

        String[] result = sortPeople(names, heights);

        System.out.println("Output        : " + Arrays.toString(result));
    }
}