import java.util.Arrays;

public class JavaStreamsAverage {

    public static double average(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .orElse(0.0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        double avg = average(arr);
        System.out.println(avg);
    }
}