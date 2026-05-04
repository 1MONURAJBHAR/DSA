package String;

/**
 * Demonstrates difference between '==' and equals() in Java Strings.
 *
 * Key Concepts:
 * 1. '==' → compares references (memory addresses)
 * 2. equals() → compares actual content (values inside the string)
 * 3. String literals are stored in String Pool (memory optimization)
 * 4. 'new' keyword creates a separate object in heap memory
 */
public class EqualToFunction {

    public static void main(String[] args) {

        // String literals → stored in String Pool
        // Both s1 and s2 point to SAME memory location
        String s1 = "hello";
        String s2 = "hello";

        // 'new' keyword → creates a NEW object in heap memory
        // Even though value is same, memory location is different
        String s3 = new String("hello");

        // '==' compares memory references
        System.out.println(s1 == s2);  // true → same reference (String Pool)

        System.out.println(s1 == s3);  // false → different objects (Pool vs Heap)

        // equals() compares actual content
        System.out.println(s1.equals(s3));  // true → values are same
    }
}