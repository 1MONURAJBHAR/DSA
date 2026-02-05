public class floorValueofAnElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,8,8,10,10,11};
        int n = floorValue(arr,9);
        System.out.println("Value: "+n);
    }

    //Largest number <= target
    static int floorValue(int[] arr, int target){
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target){
                ans = mid;
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return ans != -1 ? arr[ans] : -1;
    }
}
