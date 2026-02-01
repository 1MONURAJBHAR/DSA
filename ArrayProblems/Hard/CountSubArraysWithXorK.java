import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithXorK {
    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int ans = CountSubArrays3(arr,6);
        System.out.println(ans);
    }

    //T.C:O(n), worst case-->O(n^2), S.C:O(n)
    static int CountSubArrays3(int[] arr, int k1) {
        int n = arr.length;
        int count = 0;
        int xor = 0;

        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);

        for (int i = 0; i < n; i++){
            xor = xor^arr[i];
            int x = xor^k1;

            /*Why add frequency:
            Same prefix XOR can occur multiple times
            Each occurrence forms a valid subArray*/
            if (mpp.containsKey(x)){
                count = count + mpp.get(x);
            }
            mpp.put(xor, mpp.getOrDefault(xor,0)+1);
        }
        return count;
    }


    //T.C:O(n^2), S.C:O(1)
    static int CountSubArrays2(int[] arr, int k1) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++){
            int xor = 0;
            for (int j = i; j < n; j++){
                xor = xor^arr[j];

                if (xor == k1){
                    count++;
                }
            }

        }
        return count;
    }



    //T.C:O(n^3), S.C:O(1)
    static int CountSubArrays(int[] arr, int k1) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor = xor ^ arr[k];
                }

                if (xor == k1) {
                    count++;
                }
            }
        }
        return count;
    }
}
