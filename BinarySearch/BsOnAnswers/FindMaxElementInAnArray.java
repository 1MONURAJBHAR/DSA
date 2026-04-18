public class FindMaxElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {6,4,7,8,9};
        int ans = findMax(arr);
        System.out.println(ans);
    }

    //best & valid for all numbers
    static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //valid for all numbers
    static int findMax3(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    //not valid for negative numbers
    static int findMax2(int[] piles){
        int max = 0;

        for (int bananas: piles){
            if (bananas > max){
                max = bananas;
            }
        }
        return max;
    }

}
