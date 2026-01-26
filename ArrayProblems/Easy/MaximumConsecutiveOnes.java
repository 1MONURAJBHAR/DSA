public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
      int[] arr = {1,1,0,1,1,1,1,0,1,1};
      int ans = maxConsecutive(arr);
      System.out.println(ans);
    }
    //T.C: O(n), S.C: O(1), no brute or better approach, directly optimal approach.
    static int maxConsecutive(int[] arr){
        int max = 0;
        int count = 0;

        for (int i = 0; i<arr.length; i++){
            if(arr[i] == 1){
                count++;
                if(count>max){
                    max = count;
                }
            }else {
                count = 0;
            }
        }
        return max;
    }
}
