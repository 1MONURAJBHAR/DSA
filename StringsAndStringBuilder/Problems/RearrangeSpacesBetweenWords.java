public class RearrangeSpacesBetweenWords {
    public static String reorderSpaces(String text) {

        int totalSpaces = 0;

        // Count spaces
        for (char ch : text.toCharArray()) {
            if (ch == ' ')
                totalSpaces++;
        }

        // Extract words
        String[] arr = text.trim().split("\\s+");
        int words = arr.length;

        StringBuilder ans = new StringBuilder();

        // If only one word
        if (words == 1) {
            ans.append(arr[0]);
            for (int i = 0; i < totalSpaces; i++) {
                ans.append(" ");
            }
            return ans.toString();
        }

        int spacesBetween = totalSpaces / (words - 1);
        int extraSpaces = totalSpaces % (words - 1);

        String gap = " ".repeat(spacesBetween);

        for (int i = 0; i < words; i++) {
            ans.append(arr[i]);

            if (i != words - 1) {
                ans.append(gap);
            }
        }

        while (extraSpaces-- > 0) {
            ans.append(" ");
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String text1 = "  this   is  a sentence ";
        String text2 = " practice   makes   perfect";

        System.out.println("'" + reorderSpaces(text1) + "'");
        System.out.println("'" + reorderSpaces(text2) + "'");
    }
}
