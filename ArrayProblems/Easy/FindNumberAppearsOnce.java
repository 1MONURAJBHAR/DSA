//Find the numbers that appears once and other appears twice, in sorted array.
public class FindNumberAppearsOnce {
    public static void main(String[] args) {
        int[] arr = {1,1,5,6,6,5,7};
//        int[] arr = {4, 1, 2, 1, 2};
//        int ans = FindNumberOptimal(arr);
//        int ans = FindNumber2(arr);
        int ans = findNumberBetter(arr);
        System.out.println(ans);

    }

    //T.C:O(n), S.C:(1)
    static int FindNumberOptimal(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }


    //T.C:O(n + maxValue), S.C:O(n)
    //This works only when all numbers are >= 0 (non-negative).
    //Because you are using hash[x] as an index.
    static int findNumberBetter(int[] arr){
        int max = arr[0];

        for (int num: arr){
           // max = Math.max(num,max);
            if (num>max){
                max = num;
            }
        }

        //Create a frequency array of size (max + 1)
        int[] hash = new int[max+1];

        //Count the frequency of each number
        for (int x: arr){
            hash[x]++;
        }

        // Find the number whose frequency is exactly 1
       for (int i = 0; i<hash.length; i++){
           if (hash[i] == 1) return i;
       }
       return -1;
    }


    //T.C:O(n^2), S.C: O(1),Bruteforce
    static int FindNumber2(int[] arr){
        for (int num : arr) {
            int count = 0;

            for (int k : arr) {
                if (k == num) {
                    count++;
                }
            }

            if (count == 1) return num;

        }
        return -1;
    }

}
