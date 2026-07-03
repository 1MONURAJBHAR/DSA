public class CountBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        int prevGroup = 0;
        int currGroup = 1;
        int count = 0;

        for (int i = 1; i < s.length(); i++) {

            // If the current character is the same as the previous one,
            // increase the current group's length.
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                // A new group starts.
                // Add the minimum of the previous and current group lengths.
                count += Math.min(prevGroup, currGroup);

                // Update groups
                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        // Add the last pair of groups
        count += Math.min(prevGroup, currGroup);

        return count;
    }

    public static void main(String[] args) {

        // Predefined example
        String s = "00110011";

        System.out.println("Input : " + s);

        int result = countBinarySubstrings(s);

        System.out.println("Output: " + result);
    }
}
