public class ToggleString2 {
    public static void main(String[] args) {
         String str = "PhYSiCS";
         System.out.println("Original String : "+str);
         //StringBuilder sb = new StringBuilder(str);
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
                str = str.substring(0,i) + dh + str.substring(i+1);
            }else{
                ascii -= 32;
                char dh = (char)ascii;
                str = str.substring(0,i) + dh + str.substring(i+1);
            }
        }
        System.out.println("Toggled String : "+str);
    }
}
