public class ReverseEachWord {

    public static String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            ans.append(sb.reverse()).append(" ");
        }

        return ans.toString().trim();
    }

    public static void main(String[] args) {

        String s1 = " i like this program very much ";
        String s2 = " pqr mno ";
        String s3 = "pqr";

        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
        System.out.println(reverseWords(s3));
    }
}