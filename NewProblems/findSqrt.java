public class findSqrt {
    public static int sqrt(int n){
        int ans = 1;

        for (int i = 1; i <= n; i++){
            if (i*i <= n){
                ans = i;
            }else{
                break;
            }
        }

        return ans;
    }

    public static long sqrt2(int n){
        if(n==0 || n==1){  // Handle edge cases
            return n;
        }
        int low = 1;
        int high = n;
        int ans = 0;   // Store the closest integer square root

        while(low<=high){
            int mid = low+(high-low)/2;
            long square  = (long)mid*mid;
            if(square==n){
                return mid; //perfect square found
            }else if(square<n){
                ans = mid;   // Store possible answer
                low = mid+1;  // Search in the right half
            }else{   //square>n
                high = mid-1;  // Search in the left half
            }
        }
        return ans;  // Return the closest integer square root
    }
}
