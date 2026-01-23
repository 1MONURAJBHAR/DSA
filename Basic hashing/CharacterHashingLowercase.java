import java.util.Scanner;

public class CharacterHashingLowercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ONLY for lower case strings
        System.out.println("Enter the string: ");
        String str = sc.next();

        int[] hash = new int[26];
        for (int i = 0; i<str.length(); i++){
            hash[str.charAt(i)-'a']++;
        }

        System.out.println("Enter number of queries: ");
        int q = sc.nextInt();

        while(q-- > 0){
            System.out.println("Enter character: ");
            char ch2 = sc.next().charAt(0);

            System.out.println("Frequency of given character: "+hash[ch2-'a']);
            System.out.println("-------------------------------------------------------------");
        }


    }

    //for upper case
    /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ONLY for upper case strings
        System.out.println("Enter the string: ");
        String str = sc.next();

        int[] hash = new int[26];
        for (int i = 0; i<str.length(); i++){
            hash[str.charAt(i)-'A']++;
        }

        System.out.println("Enter number of queries: ");
        int q = sc.nextInt();

        while(q-- > 0){
            System.out.println("Enter character: ");
            char ch2 = sc.next().charAt(0);

            System.out.println("Frequency of given character: "+hash[ch2-'A']);
            System.out.println("-------------------------------------------------------------");
        }


    }*/


}
