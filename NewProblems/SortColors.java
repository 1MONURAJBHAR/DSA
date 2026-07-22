public class SortColors {
    public void sortColors(int[] nums) {
        //Arrays.sort(nums);  //simple onle line solution

        int start = 0;
        int mid = 0;
        int end = nums.length-1;

        while(mid<=end){
            switch(nums[mid]){
                case 0:
                    swap(nums,start,mid);
                    start++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(nums,end,mid);
                    end--;
                    break;
            }
        }
    }

    static void swap(int[] num, int pos1,int pos2){
        int temp = num[pos1];
        num[pos1] = num[pos2];
        num[pos2] = temp;
    }
}
