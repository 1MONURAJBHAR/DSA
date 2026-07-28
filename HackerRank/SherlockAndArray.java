public class SherlockAndArray {
    public static String balancedSums(int[] arr){
        int total = 0;

        // Calculate total sum of the array
        for (int num : arr) {
            total += num;
        }

        int leftSum = 0;

        // Traverse the array
        for (int num : arr) {

            // Sum of elements on the right
            int rightSum = total - leftSum - num;

            // Check if left and right sums are equal
            if (leftSum == rightSum) {
                return "YES";
            }

            // Update left sum
            leftSum += num;
        }

        return "NO";
    }
}
