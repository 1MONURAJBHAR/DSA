public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume first string is the prefix
        String prefix = strs[0];

        // Compare with every other string
        for (int i = 1; i < strs.length; i++) {

            // Shorten prefix until current string starts with it
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;


         /* Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];

        int index = 0;

        while(index < str1.length()){
            if(str1.charAt(index) == str2.charAt(index)){
                index++;
            }else{
                break;
            }
        }

        return index == 0 ? "" : str1.substring(0,index);*/
    }

    public static void main(String[] args) {

        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(strs1)); // fl
        System.out.println(longestCommonPrefix(strs2)); // ""
    }
}