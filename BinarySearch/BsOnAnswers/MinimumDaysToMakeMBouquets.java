public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,13,11,12,7};
        int ans = minDays(arr, 2,3);
        System.out.println("Minimum Days To Make M Bouquets: "+ans);
    }


    static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < (long)m * k) return -1;

        //Linear approach
        // int min = findMin(bloomDay);
        // int max = findMax(bloomDay);

        // for(int i = min; i <= max; i++){
        //     boolean val = Possible(bloomDay,i,m,k);
        //     if(val) return i;
        // }
        // return -1

        //binary approach
        int low = findMin(bloomDay);
        int high = findMax(bloomDay);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (Possible1(bloomDay, mid, m, k)) {
                high = mid - 1;  // try smaller day
            } else {
                low = mid + 1;   // need more days
            }
        }
        return low;
    }

    static boolean Possible(int[] arr, int day, int m, int k){
        int count = 0; int bonquets = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day){
                count++;  //consecutive flowers ko count karo jo us din bloom karenge
            }else{
                bonquets += (count/k);  //next element pe jaane se pehle check karo ki itne consecutive flowers se koi bonquet ban sakta hai? + agar ban sakta hai toh add karo 
                count = 0;
            }
        }
        bonquets += (count/k);  //check karo kya counted consecutive flowers se bonquets ban sakta hai? + agar ban sakta hai toh add karo

        return bonquets >= m;
    }

    //OR this possible function
    static boolean Possible1(int[] arr, int day, int m, int k){
        int count = 0, bouquets = 0;

        for(int val : arr){
            if(val <= day){
                count++;
                if(count == k){   //three consecutive flowers khil/bloom kar gaye
                    bouquets++;   //Ab bonquets ban sakte hain
                    count = 0;    //ready for next set of flowers
                }
            } else {

                count = 0;
            }
        }

        return bouquets >= m;
    }



    static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}

