public class BoyerMooreVotingAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,1,2,2};

        int ans = MajorityElementOptimal(arr);
        System.out.println("Majority element: "+ans);
    }

    //T.C: O(n) S.C: O(1), if the problem states that there must exists a majority element in the array.
    static int MajorityElementOptimal2(int[] arr){
        int n = arr.length;
        int candidate = 0;
        int count = 0;

        for (int num: arr){
            if (count == 0){
                candidate = num;
            }

            if (num == candidate) count++;
            else count--;
        }

        return candidate;
    }


    //T.C: O(n)+O(n) S.C: O(1)   if the problem states that there may or may not exists a majority element in the array.
    static int MajorityElementOptimal(int[] arr){
        int n = arr.length;
        int candidate = 0;
        int count = 0;

        for (int num: arr){
            if (count == 0){
                candidate = num;
            }

            if (num == candidate) count++;
            else count--;
        }

        int freq = 0;
        for (int num: arr){
            if (num == candidate) freq++;
        }

        if (freq > n/2) return candidate;

        return -1;
    }
}
