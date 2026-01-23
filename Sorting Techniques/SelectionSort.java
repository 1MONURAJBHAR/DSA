import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9,7,6,3,4,5,2,1};
        SelectionSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
/*Selection Sort Approach
Start from index 0
Assume current element is minimum
Search the smallest element in the remaining unsorted part (i+1 to n-1)
Swap the smallest element with the element at index i
Move to next index and repeat until array is sorted*/

    //T.C --> O(n^2)
    static void SelectionSort1(int[] arr){
        int n = arr.length;
        for (int i = 0; i<n-1; i++){
            int minIndex = i;

            // find minimum element index in unsorted part
            for (int j = i+1; j<n; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            // swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
