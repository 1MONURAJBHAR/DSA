package String;

public class SubStringQuestions {
    public static void findSubString(){
        String s = "Physics";

        for (int i = 2; i < 4; i++){
            System.out.print(s.substring(i));    //will print ysicssics
        }
    }

    public static void findSubString2(){
        String S = "abcd";

        for (int i = 0; i < S.length(); i++){
            for (int j = i+1; j <= S.length(); j++){
                System.out.print(S.substring(i,j) + " ");
            }
        }
    }

    public static void main(String[] args) {
        //findSubString();
        findSubString2();
    }
}
