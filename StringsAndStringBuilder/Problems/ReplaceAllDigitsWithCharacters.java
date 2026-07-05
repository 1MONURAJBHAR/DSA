/*Every odd index is a digit. That digit tells you how many positions to move forward from the letter immediately before it, and you replace the digit with the resulting letter.
 The problem guarantees the shift will never go past 'z', so you don't need to handle wrapping around the alphabet.*/
public class ReplaceAllDigitsWithCharacters {

    public static String replaceDigits(String s) {

        char[] arr = s.toCharArray();

        for (int i = 1; i < arr.length; i += 2) {

            arr[i] = (char) (arr[i - 1] + (arr[i] - '0'));
        }

        return new String(arr);
    }

    public static void main(String[] args) {

        String s1 = "a1c1e1";
        String s2 = "a1b2c3d4e";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + replaceDigits(s1));

        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Output: " + replaceDigits(s2));
    }
}