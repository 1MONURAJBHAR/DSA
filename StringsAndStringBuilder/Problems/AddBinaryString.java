public class AddBinaryString {
    public static String addBinary(String s1, String s2) {

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1) {

            int sum = carry;

            if (i >= 0) {
                sum += s1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += s2.charAt(j) - '0';
                j--;
            }

            ans.append(sum % 2);
            carry = sum / 2;
        }

        // Reverse the answer
        ans.reverse();

        // Remove leading zeros
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s1 = "1101";
        String s2 = "111";

        String result = addBinary(s1, s2);

        System.out.println("First Binary : " + s1);
        System.out.println("Second Binary: " + s2);
        System.out.println("Result       : " + result);
    }
}

