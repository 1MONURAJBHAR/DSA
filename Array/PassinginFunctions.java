import java.util.Arrays;

public class PassinginFunctions {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(nums));
        change(nums);//copy of the reference variable is passed in the function.
        System.out.println(Arrays.toString(nums));
    }
    static void change(int[] arr){ //this arr is pointing to the same object in the heap memory.
        arr[0] = 99; //this will change the original object in the heap memory.
    }
}
