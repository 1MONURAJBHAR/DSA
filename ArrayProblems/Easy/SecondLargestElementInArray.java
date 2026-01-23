import java.util.Arrays;

public class SecondLargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {5,4,2,7,8,9,9,9,9,2};
//        int ans = LargestElement(arr);
//        int ans = SecondLargestElement2(arr);
//        int ans = SecondLargestElement3(arr);
        int ans = SecondLargestElement4(arr);
        int ans2 = SecondSmallestElement4(arr);
        System.out.println("Second smallest element: "+ans2);
        System.out.println("Second largest Element: "+ans);
    }
    //Brute force approach: T.C --> O(nlog(n)) "since sorting is used"
    static int SecondLargestElement2(int[] arr){
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Need at least 2 elements");
        }

        Arrays.sort(arr);

        int largest = arr[arr.length-1];

        for (int i = arr.length-2; i>=0; i--){
            if (arr[i] < largest){
                return arr[i]; // first smaller from end = second largest
            }
        }
        //return -1; //if second largest element does not exist
        throw new IllegalArgumentException("Second largest does not exist (all elements same)");
    }

    //Better approach: T.C--> O(2n)
    static int SecondLargestElement3(int[] arr){
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Need at least 2 elements");
        }

        int n = arr.length;
        int largest = arr[0];
        for (int i = 0; i<n; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        int secondLargest = 0;
        for (int j = 0; j<n; j++){
            if (arr[j]>secondLargest && arr[j] != largest){
                secondLargest = arr[j];
            }
        }
        return secondLargest;
    }

    //optimal approach: T.C = O(n)
    static int SecondLargestElement4(int[] arr){
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }else if (arr[i] < largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
    //optimal approach: T.C = O(n)
    static int SecondSmallestElement4(int[] arr){
        int smallest = arr[0];
        int SecondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++){
            if(arr[i]<smallest){
                SecondSmallest = smallest;
                smallest = arr[i];
            }else if (arr[i] > smallest && arr[i] < SecondSmallest){
                SecondSmallest = arr[i];
            }
        }
        if (SecondSmallest == Integer.MAX_VALUE)
            throw new IllegalArgumentException("Second smallest doesn't exist");

        return SecondSmallest;
    }
}
