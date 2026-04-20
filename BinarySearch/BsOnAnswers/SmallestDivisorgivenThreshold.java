
public class SmallestDivisorgivenThreshold {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        int threshold = 6;
        int ans = smallestDivisorBS(arr,threshold);
        System.out.println(ans);
    }

    //linear search
    static int smallestDivisor(int[] nums, int threshold){
        if (nums.length > threshold) return -1;   //nums.length is the minimum sum which we can have, if threshold is less then this its not possible
        int max = getMax(nums);

        for (int d = 1; d <= max; d++){
            int sum = 0;

            for (int num: nums){
                sum += (num + d -1) / d; //ceil division
            }
            // "Smallest divisor d such that sum of ceil value of  ⌈nums[i]/d⌉ ≤ threshold"
            //Many divisors may satisfy the condition, But we must return the minimum valid one
            if (sum <= threshold){
                return d;
            }
        }
        return -1;
    }

    //binary search
    static int smallestDivisorBS(int[] nums, int threshold){

        if (nums.length > threshold) return -1;    //nums.length is the minimum sum which we can have, if threshold is less then this its not possible

        int low = 1;
        int high = getMax(nums);

        while (low <= high){
            int mid = low + (high - low) / 2;

            int val = computeSum(nums, mid);

            if (val <= threshold){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    //finds sum of ceil value of ⌈nums[i]/d⌉
    static int computeSum(int[] arr, int d){
        int sum = 0;

        for (int num : arr){
            sum += (num + d - 1) / d;  // ceil division
        }

        return sum;
    }

    static int getMax(int[] nums){
        int max = 0;
        for (int num: nums){
            max = Math.max(max, num);
        }
        return max;
    }
}
