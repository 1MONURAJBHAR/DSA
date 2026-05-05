/**
 * Reverse each word in a sentence without changing word order.
 * Example: "I am an online educator" → "I ma na enilno rotacude"
 *
 * Time: O(n)
 * Space: O(n)
 */
public class ReverseWordsInSentence2 {

    public static void main(String[] args) {

        String str = "I am an online educator";

        StringBuilder result = new StringBuilder(); // final answer
        StringBuilder word = new StringBuilder();   // current word

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch != ' ') {
                // build current word
                word.append(ch);
            } else {
                // reverse and add word to result
                result.append(word.reverse());
                result.append(" ");

                // reset word builder
                word.setLength(0);
            }
        }

        // handle last word
        result.append(word.reverse());

        System.out.println(result.toString());
    }
}