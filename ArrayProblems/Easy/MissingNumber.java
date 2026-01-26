public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
//        int ans = findNumberBruteForce(arr);
//        int ans = findNumberBetterApproach(arr);
//        int ans = findNumberOptimalSumMethod(arr);
        int ans = findNumberOptimalXorMethod(arr);
        System.out.println(ans);
    }

    //Works for:
//    Array contains numbers from 1 to n with one missing
//    Example: [1,2,4,5] → missing = 3
    //T.C: O(n), S.C:O(1), slightly better then sum method.
    static int findNumberOptimalXorMethod(int[] arr){
        int n = arr.length+1;

        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < n-1; i++){
            xor1 = xor1^(i + 1);  // 1->n-1; (i.e:1->4)
            xor2 = xor2^arr[i];
        }
        xor1 = xor1^n; //remaining last xor with n: xor1^n, i.e: xor1^5

        return xor1^xor2;
    }

//    Works for:
//    Array contains numbers from 0 to n with one missing
//    Example: [3,0,1] → missing = 2
        static int findNumberOptimalXorMethod2(int[] arr) {
            int n = arr.length;

            int xor1 = 0;
            int xor2 = 0;

            for (int i = 0; i < n; i++) {
                xor1 ^= i;       // XOR of 0..(n-1)
                xor2 ^= arr[i]; // XOR of array values
            }

            xor1 ^= n; // include n

            return xor1 ^ xor2;
        }





    //T.C: O(n), S.C:O(1)
    static int findNumberOptimalSumMethod(int[] arr){
        int n = arr.length+1;  //for missing number add 1

        int TotalSum = (n*(n+1))/2;

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        return TotalSum-sum;
    }




    /*This approach assumes:
      all values are in range 1 to n+1
      only one number is missing
      no invalid numbers like 0, negative, or > n+1*/

    //T.C: O(n)+O(n), S.C: O(n)
    static int findNumberBetterApproach(int[] arr) {
        int n = arr.length + 1; // range is 1..n, for missing number add 1
        int[] hash = new int[n + 1]; // index 0 unused

        for (int x : arr) {
            hash[x]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }


   /* static int findNumberBetterApproach(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n+2];

        for (int x: arr){
            hash[x]++;
        }

        for (int i = 1; i<n+2; i++){
            if (hash[i] == 0){
                return i;
            }
        }
        return -1;
    }*/


    //T.C: O(n), S.C: O(1)
    static int findNumberBruteForce(int[] arr) {
        int n = arr.length + 1; // because 1 number is missing

        for (int i = 1; i <= n; i++) {
            int flag = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                return i; // missing number
            }
        }
        return -1;
    }
}
