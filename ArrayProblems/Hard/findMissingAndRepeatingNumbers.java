import java.util.Arrays;
import java.util.List;

public class findMissingAndRepeatingNumbers {
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
//        List<Integer> ans = findNumbersUsingHashingArray(arr);
//        System.out.println(ans);
        int[] ans = findMissingAndRepeatingXOR(arr);
        System.out.println("Repeating: " + ans[0]);
        System.out.println("Missing: " + ans[1]);

    }

    //Bit manipulation concept is important
    // T.C: O(n), S.C: O(1), XOR based (no overflow risk)
    static int[] findMissingAndRepeatingXOR(int[] arr) {
        int n = arr.length;

        int xor = 0;

        // XOR all array elements and numbers from 1..n
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            xor ^= (i + 1);
        }

        // Get rightmost set bit
        int rsb = xor & -xor;

        int x = 0, y = 0;

        // Divide elements into two groups
        for (int num : arr) {
            if ((num & rsb) != 0) x ^= num;
            else y ^= num;
        }

        for (int i = 1; i <= n; i++) {
            if ((i & rsb) != 0) x ^= i;
            else y ^= i;
        }

        // Determine which is repeating and which is missing
        for (int num : arr) {
            if (num == x) {
                return new int[]{x, y}; // x repeating, y missing
            }
        }

        return new int[]{y, x}; // y repeating, x missing
    }



    //T.C:O(n), S.C:O(1), super simple
    static int[] findMissingAndRepeating(int[] arr){
        int n = arr.length;

        long SN = (long) n * (n + 1) / 2;          // Sum of 1..n
        long S2N = (long) n * (n + 1) * (2L * n + 1) / 6;   // Sum of squares of 1..n

        long S = 0, S2 = 0;

        for (int num: arr){
            S += num;
            S2 += (long) num * num;
        }

        long val1 = S - SN;      // x - y (repeating - missing)
        long val2 = S2 - S2N;    // x^2 - y^2
        val2 = val2 / val1;      //x + y

        long x = (val1 + val2) / 2;  // repeating number
        long y = x - val1;           // missing number

        return new int[]{(int) x, (int) y};
    }




    //T.C:O(2n), S.C:O(n)
    static List<Integer> findNumbersUsingHashingArray(int[] arr){
        int n = arr.length;
        int[] hash = new int[n+1];
        int repeating = -1, missing = -1;


        for (int num: arr){
            hash[num]++;
        }

        for (int i = 1; i < n+1; i++){
            if (hash[i] == 2){
                repeating = i;
            }
            if (hash[i] == 0){
                missing = i;
            }
        }
        return Arrays.asList(repeating,missing);
    }

    //T.C:O(n^2), S.C:O(1)
    static List<Integer> findNumbers(int[] arr) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int num : arr) {
                if (num == i) {
                    count++;
                }
            }

            if (count == 2) repeating = i;
            if (count == 0) missing = i;
        }

        return Arrays.asList(repeating, missing);
    }
}
