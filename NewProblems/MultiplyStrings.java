public class MultiplyStrings {

    // Function to multiply two numbers represented as strings
    public String multiply(String num1, String num2) {

        // If either number is 0, the answer is always 0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // Maximum possible digits in the result = m + n
        int[] result = new int[m + n];

        // Traverse both strings from right to left
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                // Convert characters to integers and multiply
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                /*
                 * p2 -> Position where the current digit is stored.
                 * p1 -> Position where the carry is stored.
                 *
                 * Example:
                 *   123
                 * x 456
                 * -------
                 * Product of digits contributes to indices (i+j) and (i+j+1).
                 */
                int p1 = i + j;
                int p2 = i + j + 1;

                // Add the current multiplication to the existing value
                int sum = mul + result[p2];

                // Store the unit digit
                result[p2] = sum % 10;

                // Add the carry to the previous position
                result[p1] += sum / 10;
            }
        }

        // Build the final answer by skipping leading zeros
        StringBuilder ans = new StringBuilder();

        for (int digit : result) {

            // Ignore leading zeros
            if (ans.length() == 0 && digit == 0) {
                continue;
            }

            ans.append(digit);
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        MultiplyStrings obj = new MultiplyStrings();

        String num1 = "123";
        String num2 = "456";

        String result = obj.multiply(num1, num2);

        System.out.println("Number 1 : " + num1);
        System.out.println("Number 2 : " + num2);
        System.out.println("Product  : " + result);
    }
}