import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchOnArrayList {
    public static int binarySearchAL(ArrayList<Integer> list, int k) {
        // Your code here
        int index = Collections.binarySearch(list, k);
        return index >= 0 ? index : -1;

        // If k in arr return 1, else return -1
    }
}
