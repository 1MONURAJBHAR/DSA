public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
       int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;


          /*s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
      int i = 0;
      int j = s.length() - 1;

      while(i <= j){

        if(s.charAt(i) != s.charAt(j)){
            return false;
        }

        i++;
        j--;

      }

      return true;*/
    }

    public static void main(String[] args) {

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.println(isPalindrome(s1)); // true
        System.out.println(isPalindrome(s2)); // false
        System.out.println(isPalindrome(s3)); // true
    }
}