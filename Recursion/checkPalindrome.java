public class checkPalindrome {
    public static void main(String[] args) {
        //for String
        String s = "madam";
        System.out.println(CheckStringP(0, s)); // true

        //for integer
//        int num = 121;
//        System.out.println(isPalindrome(num)); // true
    }

    //for string, T.C & S.C --> O(n/2)
    static boolean CheckStringP(int i, String s) {
        int n = s.length();
        if (i >=  n / 2) return true;

        if (s.charAt(i) != s.charAt(n - i - 1)) return false;

        return CheckStringP(i + 1, s);
    }

    //for integer, T.C & S.C --> O(n)
    static boolean isPalindrome(int n) {
        if (n < 0) return false; // negative numbers are not palindrome
        return n == reverse(n, 0);
    }

    static int reverse(int n, int rev) {
        if (n == 0) return rev;
        return reverse(n / 10, rev * 10 + (n % 10));
    }
//OR
//    static int reverse(int n, int rev) {
//        if (n == 0) return rev;              // base case: no digits left
//        int lastDigit = n % 10;              // take last digit
//        rev = rev * 10 + lastDigit;          // add digit to reverse number
//        return reverse(n / 10, rev);         // remove last digit and continue
//    }





}
