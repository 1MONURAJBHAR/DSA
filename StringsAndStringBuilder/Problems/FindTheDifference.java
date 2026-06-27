public class FindTheDifference {
    public static char findTheDifference(String s, String t){
       char ans = 0;

       for(char ch: s.toCharArray()){
           ans ^= ch;
       }

       for (char ch: t.toCharArray()){
           ans ^= ch;
       }

       return ans;
    }


    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        char result = findTheDifference(s,t);

        System.out.println("Extra character: " + result);
    }
}
