package String;

/**
 * Demonstrates String immutability and string interning in Java.
 *
 * Key Concepts:
 * 1. String literals are stored in the String Pool (inside heap memory).
 * 2. If two strings have same literal value, they point to the same memory location.
 * 3. Strings are immutable → once created, they cannot be changed.
 * 4. Reassigning a string variable creates a new object, it does NOT modify the existing one.
 */
/*
"Hello" is stored in String Pool (inside heap memory)
s and x initially point to same memory
After x = "mello":
s → "Hello"
x → "mello"
No modification happens to existing string → immutability
* */
/*
  * The String Pool (also known as the String Constant Pool) is located inside the Heap memory in modern Java.
  * Key Concepts of String StorageString Literals: When you create a string like String s1 = "Hello";,
  * it is stored in the String Pool.
  * New Keyword: Using new String("Hello"); explicitly creates a new object in the Heap memory outside the pool.
  * Interning: You can manually move a string to the pool using the intern() method, which returns a reference from the pool if the string already exists there.
  * Memory Efficiency: The pool prevents duplicate strings by reusing existing instances, which significantly reduces memory consumption*/
public class InterningAndNew {

    public static void main(String[] args) {

        // Both s and x refer to the same "Hello" object in String Pool
        String s = "Hello";
        String x = "Hello";

        // Now x is reassigned to a new string "mello"
        // A new object is created in String Pool (or reused if already exists)
        // s still points to "Hello"
        x = "mello";

        // Output original string referenced by s
        System.out.println(s);   // Output: Hello

        // Output updated string referenced by x
        System.out.println(x);   // Output: mello

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        What "new" does in Java?
//        The new keyword is used to:
//        Create an object in heap memory
//        Allocate fresh memory every time
//        Return a reference (address) to that object

        // Stored in String Pool
        String s1 = "Hello";

        // Created using 'new' → stored in heap (NOT in String Pool directly)
        String s2 = new String("Hello");

        // Comparing references (memory locations)
        System.out.println(s1 == s2);        // false

        // Comparing actual values
        System.out.println(s1.equals(s2));   // true

        s1 = s.substring(0,2) + 'y' + s.substring(3);  //s.substring(0,2)-> 0 is inclusive and 2 is exclusive(i.e takes 2-1 = 1)-->range:(0,1),  s.substring(3): takes all chars on and after index 3;
        System.out.println("New Concatenated String is : "+ s1);
    }
}

     /*
     //Key Difference: "Hello" vs new String("Hello")
        | Feature         | `"Hello"` (Literal) | `new String("Hello")`           |
        | --------------- | ------------------- | ------------------------------- |
        | Memory Location | String Pool         | Heap (separate object)          |
        | Memory reuse    | Yes                 | No (always new object)          |
        | performance     | Faster              | Slower                          |
        | `==` comparison | May be true         | Always false (with pool string) |
      */

/*
Behind the scenes
String s = new String("Hello");
 Actually does:
        "Hello" created/checked in String Pool
         new creates another object in heap
         s points to heap object
 */
