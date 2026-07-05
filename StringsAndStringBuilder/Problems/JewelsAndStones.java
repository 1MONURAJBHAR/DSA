import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static int numJewelsInStones(String jewels, String stones) {

        Set<Character> jewelSet = new HashSet<>();

        // Store all jewels in the HashSet
        for (int i = 0; i < jewels.length(); i++) {
            jewelSet.add(jewels.charAt(i));
        }

        int count = 0;

        // Count how many stones are jewels
        for (int i = 0; i < stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Predefined example
        String jewels = "aA";
        String stones = "aAAbbbb";

        int result = numJewelsInStones(jewels, stones);

        System.out.println("Jewels: " + jewels);
        System.out.println("Stones: " + stones);
        System.out.println("Number of jewels in stones: " + result);
    }
}