public class Segregate0sAnd1s {
    public static void segregate0and1(int[] arr){
        //Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            if (arr[low] == 0) {
                low++;
            } else if (arr[high] == 1) {
                high--;
            } else {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        }
    }
}
