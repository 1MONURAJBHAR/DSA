public class FindLengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int ans = LengthOfLastWord(s);
        System.out.println("Length of last word is: "+ans);
    }

    public static int LengthOfLastWord(String s){
        String str = s.trim();
        int count = 0;

        for (int i = str.length()-1; i >= 0; i--){
            if (str.charAt(i) != ' '){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
