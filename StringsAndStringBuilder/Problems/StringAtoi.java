public class StringAtoi {

    public static int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n)
            return 0;

        // Check sign
        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        long num = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            // Overflow check
            if (sign == 1 && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign == -1 && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * num);
    }

    public static void main(String[] args) {

        String s1 = "42";
        String s2 = "   -042";
        String s3 = "1337c0d3";
        String s4 = "0-1";
        String s5 = "words and 987";
        String s6 = "2147483648";

        System.out.println(myAtoi(s1)); // 42
        System.out.println(myAtoi(s2)); // -42
        System.out.println(myAtoi(s3)); // 1337
        System.out.println(myAtoi(s4)); // 0
        System.out.println(myAtoi(s5)); // 0
        System.out.println(myAtoi(s6)); // 2147483647
    }
}