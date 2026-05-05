import java.util.Scanner;

//ASCII value of A:65 to Z:90, a:97 to z:122 .
// difference of ASCII value of a and A is 32 (i.e: (a)97 - (A)65 = 32 )

public class ToggleString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());

        System.out.println("Original String : " + str);

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            //  Ignore digits (0–9)
            if (Character.isDigit(ch)) continue;

            //  Ignore spaces
            if (ch == ' ') continue;

            //  Toggle logic
            if (Character.isUpperCase(ch)) {
                str.setCharAt(i, Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                str.setCharAt(i, Character.toUpperCase(ch));
            }

            // Any other symbol (!,@,# etc.) will be ignored automatically
        }

        System.out.println("Toggled string : " + str);
    }






   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        System.out.println("Original String : "+str);

        //setCharAt(int index, char ch) is used to replace a character at a specific index in a StringBuilder.
        //index → position to modify (0-based), character → new character to place.
       //Modifies the same object (mutable), Does NOT create a new object, Time complexity: O(1).
        for (int i = 0; i < str.length(); i++){
            boolean flag = true;
            char ch = str.charAt(i);  //returns the char at ith index in str string.

            //ignores spaces
            if (ch == ' ') continue;

            // Ignore digits (0–9)
            if (Character.isDigit(ch)) continue;

            int ascii = (int)ch;  //Typecast that char to ASCII value

            if (ascii >= 97) flag = false;  //If ASCII value is greater then 97 then the character is small character.

            if (flag == true){   //if flag is true the character is capital.
                ascii += 32;     //convert is to small by adding 32.
                char dh = (char)ascii;   //Typecast ascii to character
                str.setCharAt(i,dh);     //set character at given index.
            }else{
                ascii -= 32;
                char dh = (char)ascii;
                str.setCharAt(i,dh);
            }
        }
        System.out.println("Toggled string : "+str);
    }*/
}
