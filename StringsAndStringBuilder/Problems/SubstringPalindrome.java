//Given a string s, return the number of palindromic substrings in it.
public class SubstringPalindrome {
    public static boolean isPalindrome(String s){
        int low = 0;
        int high = s.length() - 1;
        
        while(low < high){

            // Optional: ignore spaces (uncomment if needed)
             while (low < high && s.charAt(low) == ' ') low++;
             while (low < high && s.charAt(high) == ' ') high--;
            
            if (s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {
        String str = "abcd";
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            for (int j = i+1; j <= str.length(); j++){
                if (isPalindrome(str.substring(i,j))){
                    System.out.print(str.substring(i,j)+ " ");
                    count++;
                }
            }
        }

        System.out.println("\nThe number of palindromic substrings are : "+count);
    }
}
