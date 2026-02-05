import java.util.Arrays;
import java.util.List;

public class CountOccurencesOfnumberInASortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int target = 2;
        int ans = findnumberOfOccurences(arr, target);
        System.out.println("Occurrence of number is: "+ans);
    }

    static int CountOccurencesOfnumber(int[] arr, int target){
        int n = arr.length;

        int first = firstOccurence(arr, target, n);
        if (first == -1) return 0;

        int last = lastOccurence(arr, target, n);
        return last-first+1;
    }

    static int firstOccurence(int[] arr, int target, int n){
        int low = 0, high = n-1;
        int first = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] < target){
                low = mid + 1;
            }else if (arr[mid] > target){
                high  = mid - 1;
            }else{
                first = mid;
                high = mid - 1;
            }
        }
        return first;
    }

    static int lastOccurence(int[] arr, int target, int n){
        int low = 0, high = n-1;
        int last = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] < target){
                low = mid + 1;
            }else if (arr[mid] > target){
                high  = mid - 1;
            }else{
                last = mid;
                low = mid+1;
            }
        }
        return last;
    }

    static int findnumberOfOccurences(int[] arr, int target){
        int n = arr.length;
        int first = 0, last = 0;

        for (int i = 0; i < n; i++){
            if (arr[i] == target){
                if (first == 0){
                    first = i;
                }
                last = i;
            }
        }
        return last - first + 1;
    }

}
