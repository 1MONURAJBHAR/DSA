import java.util.*;
public class CapacityToShipPackagesWithinDdays {
    public int leastWeightCapacity(ArrayList<Integer> arr, int D) {
        // code here
        int low = findMax(arr);
        int high = sumOfAll(arr);

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(daysReq(arr, mid) <= D){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }


    public static int daysReq(ArrayList<Integer> arr, int Capacity){
        int day = 1;
        int load = 0;

        for(int i = 0; i < arr.size(); i++){
            if(load + arr.get(i) > Capacity){
                day++;
                load = arr.get(i);
            }else{
                load += arr.get(i);
            }
        }
        return day;
    }


    public static int findMax(ArrayList<Integer> arr){
        int max = 0;

        for(int num: arr){
            max = Math.max(max, num);
        }

        return max;
    }

    public static int sumOfAll(ArrayList<Integer> arr){
        int sum = 0;

        for(int num: arr){
            sum += num;
        }

        return sum;
    }
}
