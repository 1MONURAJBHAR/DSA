import java.util.Scanner;

public class CharacterHashingGeneral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ONLY for lower case strings
        System.out.println("Enter the string: ");
        String str = sc.next();

        int[] hash = new int[256];
        for (int i = 0; i<str.length(); i++){
            hash[str.charAt(i)]++;
        }

        System.out.println("Enter number of queries: ");
        int q = sc.nextInt();

        while(q-- > 0){
            System.out.println("Enter character: ");
            char ch2 = sc.next().charAt(0);

            System.out.println("Frequency of given character: "+hash[ch2]);
            System.out.println("-------------------------------------------------------------");
        }
        sc.close();
    }
}
