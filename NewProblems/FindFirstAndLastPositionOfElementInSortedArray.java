public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2]; //to return first & last position
        arr[0] = findfirst(nums,target);
        arr[1] = findlast(nums,target);
        return arr;

        //Linear approach ------->O(n)
        /*int n = arr.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if (target != arr[i]){
                continue;
            }else if (first == -1){
                first = i;
            }
                last = i;
        }
        if (first != -1) {
            return new int[]{first,last};
        }
        return new int[]{-1,-1};*/
    }

    //Binary approach --------->O(logn)
    static int findfirst(int[] nums, int target){
        int start = 0,end = nums.length-1,pos =  -1;

        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                pos = mid;
                end = mid-1;
            }
        }
        return pos;
    }

    static int findlast(int[] nums, int target){
        int start = 0,end = nums.length-1,pos =  -1;

        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                pos = mid;
                start = mid+1;
            }
        }
        return pos;
    }
}
