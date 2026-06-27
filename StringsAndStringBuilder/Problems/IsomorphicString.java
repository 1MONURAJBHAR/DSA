import java.util.HashMap;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2)
                    return false;
            } else {
                mapST.put(c1, c2);
            }

            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1)
                    return false;
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {

        HashMap<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (hm.containsKey(c1)) {

                if (!hm.get(c1).equals(c2)) {
                    return false;
                }

            } else {

                // Another character is already mapped to c2
                if (hm.containsValue(c2)) {
                    return false;
                }

                hm.put(c1, c2);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        //methods are not static
        IsomorphicString obj = new IsomorphicString();

        // Test Case 1
        String s1 = "egg";
        String t1 = "add";
        System.out.println("Test Case 1:");
        System.out.println("Method 1: " + obj.isIsomorphic(s1, t1));
        System.out.println("Method 2: " + obj.isIsomorphic2(s1, t1));
        System.out.println();

        // Test Case 2
        String s2 = "f11";
        String t2 = "b23";
        System.out.println("Test Case 2:");
        System.out.println("Method 1: " + obj.isIsomorphic(s2, t2));
        System.out.println("Method 2: " + obj.isIsomorphic2(s2, t2));
        System.out.println();

        // Test Case 3
        String s3 = "paper";
        String t3 = "title";
        System.out.println("Test Case 3:");
        System.out.println("Method 1: " + obj.isIsomorphic(s3, t3));
        System.out.println("Method 2: " + obj.isIsomorphic2(s3, t3));
        System.out.println();

        // Test Case 4
        String s4 = "ab";
        String t4 = "aa";
        System.out.println("Test Case 4:");
        System.out.println("Method 1: " + obj.isIsomorphic(s4, t4));
        System.out.println("Method 2: " + obj.isIsomorphic2(s4, t4));
    }
}
