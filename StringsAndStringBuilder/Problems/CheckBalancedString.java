import java.util.Scanner;

public class CheckBalancedString {
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        // Count frequency of characters in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ransomNote: ");
        String ransomNote = sc.next();

        System.out.print("Enter magazine: ");
        String magazine = sc.next();

        boolean result = canConstruct(ransomNote, magazine);

        System.out.println(result);

        sc.close();
    }
}
