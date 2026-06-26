import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }

    static int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left + 1);
        }
        return maxLength;
    }


   /* public static int lengthOfLongestSubstring2(String s) {

        int start = 0;
        int end = 0;
        int maxLength = 0;

        List<Character> list = new ArrayList<>();

        while (end < s.length()) {

            if (!list.contains(s.charAt(end))) {

                list.add(s.charAt(end));
                end++;

                maxLength = Math.max(maxLength, list.size());

            } else {

                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }

        return maxLength;
    }*/
}
