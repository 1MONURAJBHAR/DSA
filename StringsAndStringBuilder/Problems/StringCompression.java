public class StringCompression {
    public static void main(String[] args) {
        String str = "aaabbbbcccdeee";
        String ans = "" + str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);

            if (curr ==  prev){
                count++;
            }else{
                if (count > 1) ans += count;
                count = 1;
                ans += curr;
            }
        }
        if (count > 1) ans += count;
        System.out.println(ans);


        /* better version
        StringBuilder ans = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {

            while (i < str.length() - 1 &&
                   str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            ans.append(str.charAt(i));

            if (count > 1) {
                ans.append(count);
            }

            count = 1;
        }

        return ans.toString();
        */
    }
}
