/**
 * Demonstrates various StringBuilder operations in Java.
 *
 * Key Points:
 * - StringBuilder is mutable (modifies same object)
 * - Efficient for multiple string operations
 * - Most methods change the original object directly
 */

/*
StringBuilder → mutable & fast.
append(), insert(), delete() → modify same object.
reverse() → in-place change (no new object).
substring() →  returns String, not StringBuilder.
* */
public class Builder {

    public static void main(String[] args) {

        // ---------------- INITIALIZATION ----------------

        // Create StringBuilder object
        StringBuilder str = new StringBuilder("hello ");
        System.out.println(str);   // Output: hello 


        // ---------------- setCharAt() ----------------

        // Replaces character at given index
        str.setCharAt(0, 'm');
        System.out.println(str);   // Output: mello 


        // ---------------- append() ----------------

        // Adds content at the end
        str.append("world");
        // str.append(true);  // also valid
        // str.append(10);    // also valid
        System.out.println(str);   // Output: mello world


        // ---------------- insert() ----------------

        // Inserts character at specific index
        str.insert(0, 'h');
        System.out.println(str);   // Output: hmello world


        // ---------------- deleteCharAt() ----------------

        // Removes character at given index
        str.deleteCharAt(0);
        System.out.println(str);   // Output: mello world


        // ==================================================
        //           SECOND EXAMPLE (Physics)
        // ==================================================

        StringBuilder sb = new StringBuilder("Physics");
        System.out.println(sb);   // Output: Physics


        // ---------------- reverse() ----------------

        // Reverses the string
        sb.reverse();
        System.out.println(sb);   // Output: scisyhP

        // Reverse again to restore original
        sb.reverse();
        System.out.println(sb);   // Output: Physics


        // ---------------- delete(start, end) ----------------

        // Removes characters from index 'start' (inclusive)
        // to 'end' (exclusive)
        // Example: delete(2,4) removes index 2 and 3
        // sb.delete(2, 4);   // Uncomment to test
        System.out.println(sb);   // Output: Physics


        // ---------------- substring() ----------------

        // Returns a NEW String (not StringBuilder)
        // Extracts from index to end
        System.out.println(sb.substring(3));   // Output: sics


        //////////////////////////////////////////////////////////////////////////////
        //substring() in StringBuilder does NOT modify the original object
        //It returns a new String
        //Since you didn’t store it anywhere, it’s simply discarded, store result in "result" variable of String data type.
        StringBuilder sb2 = new StringBuilder("abc");
        //store result,  if you didn’t store it anywhere, it’s simply discarded.
        String result = sb2.substring(1);   // Does NOT modify sb2

        System.out.println(result);  //"bc"
        System.out.println(sb2); // still "abc"
    }
}