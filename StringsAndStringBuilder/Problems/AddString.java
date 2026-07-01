class AddString {

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;

            sb.append(sum % 10);

            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String num1 = "456";
        String num2 = "77";

        String result = addStrings(num1, num2);

        System.out.println("First Number : " + num1);
        System.out.println("Second Number: " + num2);
        System.out.println("Sum          : " + result);
    }
}
