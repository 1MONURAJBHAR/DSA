/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.*/
public class RemoveDuplicatesUsingTwoPointer {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        int UniqueElements = RemoveDuplicates(arr);
        System.out.println("Unique Elements: "+UniqueElements);
    }

    //T.C --> O(n), S.C-->O(1)
    static int RemoveDuplicates(int[] arr){
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int i = 0;

        for (int j = 1; j < n; j++){
            if(arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }

    /*static int removeDuplicates(int[] arr) {
    if (arr == null || arr.length == 0) return 0;

    int i = 0;
    for (int j = 1; j < arr.length; j++) {
        if (arr[j] != arr[i]) {
            i++;
            arr[i] = arr[j];
        }
    }
    return i + 1;
}*/
}
