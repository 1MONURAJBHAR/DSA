public class ReverseEachWordInAGivenString {
    public static String reverseString(String str){
        String[] words = str.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (String word: words){
          StringBuilder sb = new StringBuilder(word);
          ans.append(sb.reverse()).append(" ");
        }

        return ans.toString().trim();
    }

    public static String reverseString2(String str){
        String ans = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if (ch != ' '){
                sb.append(ch);
            }else{
                sb.reverse();
                ans += sb;
                ans += " ";
                sb = new StringBuilder("");
            }
        }
        sb.reverse();
        ans += sb;
        System.out.println(ans);
        return ans.trim();
    }
}
