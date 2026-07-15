import java.util.Scanner;

public class CountAndSay {

    // Function to generate the nth term of the Count and Say sequence
    public static String countAndSay(int n) {

        // Base case: The first term is always "1"
        String result = "1";

        // Generate terms from 2 to n
        for (int i = 2; i <= n; i++) {

            // Stores the next term
            StringBuilder sb = new StringBuilder();

            // Counts consecutive occurrences of a character
            int count = 1;

            // Traverse the current term
            for (int j = 1; j < result.length(); j++) {

                // If current character is same as previous, increase count
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    // Append the count and the previous character
                    sb.append(count);
                    sb.append(result.charAt(j - 1));

                    // Reset count for the new character
                    count = 1;
                }
            }

            // Append the last group of characters
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));

            // Update result for the next iteration
            result = sb.toString();
        }

        // Return the nth term
        return result;
    }

    public static String countAndSayRecurrsion(int n) {

        // Base case
        if (n == 1) {
            return "1";
        }

        // Get the previous term recursively
        String previous = countAndSay(n - 1);

        // Build the current term
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < previous.length(); i++) {

            if (previous.charAt(i) == previous.charAt(i - 1)) {
                count++;
            } else {
                result.append(count);
                result.append(previous.charAt(i - 1));
                count = 1;
            }
        }

        // Append the last group
        result.append(count);
        result.append(previous.charAt(previous.length() - 1));

        return result.toString();
    }

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Read the value of n
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // Print the nth Count and Say term
        System.out.println("Count and Say Sequence: " + countAndSay(n));

        // Close the Scanner
        sc.close();
    }
}