import java.util.*;

public class FindWordsContainingCharacter {
    public static List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                ans.add(i);
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        System.out.print("Enter character to search: ");
        char x = sc.next().charAt(0);

        List<Integer> result = findWordsContaining(words, x);

        System.out.println("Indices containing '" + x + "': " + result);

        sc.close();
    }
}
