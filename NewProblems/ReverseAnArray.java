public class ReverseAnArray {
    public static void reverseUsingWhileLoop(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void reverseUsingForLoop(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n / 2; i++){
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}
