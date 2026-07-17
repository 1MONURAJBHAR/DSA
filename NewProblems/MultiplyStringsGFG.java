public class MultiplyStringsGFG {
    public String multiplyStrings(String s1, String s2) {

        boolean negative = false;

        // Check sign of first number
        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }

        // Check sign of second number
        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }

        // Remove leading zeros
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);

        // If either number is zero
        if (s1.equals("0") || s2.equals("0"))
            return "0";

        int m = s1.length();
        int n = s2.length();

        int[] result = new int[m + n];

        // Grade-school multiplication
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuilder ans = new StringBuilder();

        // Skip leading zeros
        for (int digit : result) {

            if (ans.length() == 0 && digit == 0)
                continue;

            ans.append(digit);
        }

        // Add negative sign if required
        if (negative)
            ans.insert(0, '-');

        return ans.toString();
    }


    // Removes leading zeros
    static String removeLeadingZeros(String s) {

        int i = 0;

        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }

        return s.substring(i);
    }
}
