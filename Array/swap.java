import java.util.Arrays;

public class swap {
    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 45, 56, 78, 98};
        //swap(arr, 0, 5);
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    //reverse an array using the existing swap function.
    //This method is known as two pointer method, we are using two pointers --> start & end
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start < end){
            //swap
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
