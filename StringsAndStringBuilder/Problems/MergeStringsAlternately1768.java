public class MergeStringsAlternately1768 {
    public static String mergeAlternately(String word1, String word2) {

        StringBuilder result = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(j));
            i++;
            j++;
        }

        while (i < word1.length()) {
            result.append(word1.charAt(i));
            i++;
        }

        while (j < word2.length()) {
            result.append(word2.charAt(j));
            j++;
        }

        return result.toString();
    }

    //simple as method 1
    public static String mergeAlternately2(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < word1.length() || i < word2.length()) {

            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }

            i++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));   // apbqcr
        System.out.println(mergeAlternately("ab", "pqrs"));   // apbqrs
        System.out.println(mergeAlternately("abcd", "pq"));   // apbqcd
    }
}
