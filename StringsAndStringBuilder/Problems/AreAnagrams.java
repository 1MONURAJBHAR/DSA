import java.util.*;
/*
Step 1: Check Length: If the lengths of s1 and s2 are different, return false. Reason: Anagrams must have the same number of characters.
Step 2: Convert Strings to Character Arrays
Step 3: Sort Both Arrays
Step 4: Compare Both Arrays

<----------------------------------------------------------------------->

1. If length of s1 != length of s2
       return false

2. Convert s1 to char array ch1
3. Convert s2 to char array ch2

4. Sort ch1
5. Sort ch2

6. If ch1 equals ch2
       return true
Else
       return false
*/
public class AreAnagrams {

    public static boolean areAnagrams(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        if (areAnagrams(s1, s2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }
}