
/*

You are searching for:
Minimum capacity such that reqDays ≤ given days
This is a classic monotonic condition:

If a capacity works → all larger capacities will also work
If a capacity fails → all smaller capacities will also fail

That’s why binary search is valid

* */

public class CapacityToShipPackagesWithinDdays {
    public static void main(String[] args) {
        // Input array representing weights of packages
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        // Number of days within which we must ship all packages
        int days = 5;

        // Find minimum required ship capacity
        int ans = CapacityBs(arr, days);

        // Output result
        System.out.println(ans);
    }

    //Linear approach
    // Function to find the minimum capacity needed to ship within given days
    static int Capacity(int[] nums, int days){

        // Minimum capacity must be at least the heaviest package
        int min = getMax(nums);

        // Maximum capacity can be sum of all packages (ship all in one day)
        int max = Sum(nums);

        // Try all capacities from min → max (Brute Force approach)
        for (int cap = min; cap <= max; cap++){

            // Calculate how many days this capacity would take
            int reqDays = findReqDays(nums, cap);

            // If within allowed days, this is the answer (smallest valid cap)
            if (reqDays <= days){
                return cap;
            }
        }

        // If no valid capacity found (edge case)
        return -1;
    }

    // Binary Search Approach (Optimal)
    static int CapacityBs(int[] nums, int days){

        // Lower bound = max element (minimum possible capacity)
        int low = getMax(nums);

        // Upper bound = sum of all elements (max possible capacity)
        int high = Sum(nums);

        // Binary search on capacity range
        while(low <= high){

            // Mid represents current capacity we are testing
            int cap = low + (high - low) / 2;

            // Find how many days this capacity requires
            int reqDays = findReqDays(nums, cap);

            // If we can ship within allowed days,
            // try to minimize capacity (move left)
            if (reqDays <= days){
                high = cap - 1;
            }
            // If more days required, capacity is too small → increase it
            else {
                low = cap + 1;
            }
        }

        // 'low' will point to the minimum valid capacity
        return low;
    }


    //binary approach
   /* static int CapacityBs(int[] nums, int days){
        int low = getMax(nums);
        int high = Sum(nums);

        while(low <= high){
            int cap = low + (high - low) / 2;  //mid == cap

            int reqDays = findReqDays(nums, cap);

            if (reqDays <= days){
                high = cap - 1;
            }else {
                low = cap + 1;
            }
        }
        return low;
    }*/



    // Function to calculate required days for a given capacity
    static int findReqDays(int[] nums, int cap){

        int days = 1;   // At least 1 day needed
        int load = 0;   // Current load on ship

        for (int num: nums){

            // If adding current package exceeds capacity → move to next day
            if (load + num > cap){
                days++;
                load = num; // start new day with current package
            } else {
                load += num; // add package to current day
            }
        }

        return days;
    }

    // Function to find maximum element (minimum possible capacity)
    static int getMax(int[] nums){
        int max = nums[0];

        for (int num: nums){
            max = Math.max(max, num); // keep track of largest package
        }

        return max;
    }

    // Function to calculate total weight (maximum possible capacity)
    static int Sum(int[] nums){
        int sum = 0;

        for (int num: nums){
            sum += num;
        }

        return sum;
    }
}