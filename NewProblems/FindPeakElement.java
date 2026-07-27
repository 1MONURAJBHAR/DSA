public class FindPeakElement {

    //Brute force approach
    public static int peakElement(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if ((i == 0 || arr[i-1] < arr[i]) && (i == n-1 || arr[i] > arr[i+1])){
                return i;
            }
        }
        return -1;
    }

    public static int findPeak2(int[] arr){
        int n = arr.length;

        if (arr[0] > arr[1]){
            return 0;
        }
        if(arr[n-1] > arr[n-2]){
            return n-1;
        }

        int low = 1;
        int high = n-2;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]){
                return mid;
            }else if (arr[mid] > arr[mid - 1]){
                low = mid + 1;
            }else if (arr[mid] > arr[mid + 1]){
                high = mid - 1;
            }else{
                high = mid  - 1;     //This condition is for that element which is reverse of peak element
                                     //i.e : (mid-1)>mid<(mid+1) then we can move anywhere either left or right
            }
        }

        return -1;
    }

    public static int findPeak3(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Peak lies on the right
                low = mid + 1;
            } else {
                // Peak is at mid or on the left
                high = mid;
            }
        }

        return low; // or return high;
    }
}
