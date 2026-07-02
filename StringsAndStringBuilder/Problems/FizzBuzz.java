import java.util.*;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {

        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            String s = "";

            if (i % 3 == 0)
                s += "Fizz";

            if (i % 5 == 0)
                s += "Buzz";

            if (s.isEmpty())
                s = String.valueOf(i);

            ans.add(s);
        }

        return ans;
    }


    public static List<String> fizzBuzz2(int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 15; // Predefined input

        List<String> result = fizzBuzz(n);

        System.out.println(result);

        /*
         int n = 15;

        List<String> result = fizzBuzz(n);

        for (String str : result) {
            System.out.println(str);
        }
        * */
    }
}