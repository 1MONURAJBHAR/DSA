import java.util.Arrays;
import java.util.List;

public class FirstAndLastOccurences {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int target = 2;
        List<Integer> ans = firstAndLastOccrencesBinarySearch(arr, target);
        System.out.println("first and last elements are: "+ans);
    }

    static List<Integer> firstAndLastOccrencesBinarySearch(int[] arr, int target){
        int n = arr.length;

        int first = firstOccurence(arr, target, n);
        if (first == -1) return Arrays.asList(-1,-1);

        int last = lastOccurence(arr, target, n);
        return Arrays.asList(first,last);
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



    //T.C:2*(logback2 n), S.C:O(1)
static List<Integer> firstAndLastOccrences(int[] arr, int target){
        int n = arr.length;
        int lb = lowerbound(arr,target);
        int up = upperbound(arr,target);

        if (lb == n ||arr[lb] != target) return Arrays.asList(-1,-1);
        return Arrays.asList(lb,up-1);

}

    static int lowerbound(int[] arr, int target){
        int n = arr.length;

        int low = 0, high = n-1;
        int ans = n;  //default n

        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    static int upperbound(int[] arr, int target){
        int n = arr.length;

        int low = 0, high = n-1;
        int ans = n; //default n

        while(low <= high){
            int mid = low + (high - low) / 2;

            if (arr[mid] > target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    //T.C:O(n), S.C:O(2)
    static List<Integer> firstAndLast(int[] arr, int target){
        int n = arr.length;
        int first = -1, last = -1;

        for (int i = 0; i < n; i++){
            if (arr[i] == target){
                if (first == -1){
                    first = i;
                }
                last = i;
            }
        }
        return Arrays.asList(first,last);
    }

}
