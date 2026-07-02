public class ReverseWordsInAStringIII {
    public static String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            ans.append(new StringBuilder(words[i]).reverse());

            if (i != words.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s1 = "Let's take LeetCode contest";
        String s2 = "Mr Ding";

        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
    }
}
