public class FindOccurenceOfFirstIndex {
    public static int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {

                String substr = haystack.substring(i, i + needle.length());

                if (substr.equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";

        int result = strStr(haystack, needle);

        System.out.println("Index: " + result);
    }
}
