public class MaximumProductSubarray {
    public static int maxProduct(int[] arr){
        int n = arr.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = arr[0];

        for(int i = 0; i < arr.length; i++){
            if (leftProduct == 0) leftProduct = 1;
            if (rightProduct == 0) rightProduct = 1;

            leftProduct *= arr[i];
            rightProduct *= arr[n-1-i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return ans;
    }

    public static int maxProduct2(int[] arr) {

        // Maximum product ending at the current index
        int maxProd = arr[0];

        // Minimum product ending at the current index
        // (Needed because a negative × negative becomes positive)
        int minProd = arr[0];

        // Stores the overall maximum product
        int ans = arr[0];

        // Traverse the array from the second element
        for (int i = 1; i < arr.length; i++) {

            // If the current element is negative,
            // swap maxProd and minProd because
            // multiplying by a negative reverses their roles.
            if (arr[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Either start a new subarray from arr[i]
            // or extend the previous maximum product subarray.
            maxProd = Math.max(arr[i], maxProd * arr[i]);

            // Either start a new subarray from arr[i]
            // or extend the previous minimum product subarray.
            minProd = Math.min(arr[i], minProd * arr[i]);

            // Update the overall maximum product.
            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}
