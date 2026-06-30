public class NumberOfVowelStringsInRange {
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u';
    }

    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            String word = words[i];

            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if (isVowel(first) && isVowel(last)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words1 = {"are", "amy", "u"};
        System.out.println(vowelStrings(words1, 0, 2)); // 2

        String[] words2 = {"hey", "aeo", "mu", "ooo", "artro"};
        System.out.println(vowelStrings(words2, 1, 4)); // 3
    }
}
