public class CountOcurrences {
    public static void main(String[] args) {
        int[] arr = {2,4,5,3,1,0,3};
        System.out.println("Number of occurences is: "+countOcc(3,arr));
    }

    //linear search, T.C --> O(Q*N), Q-->Total array inputs or numbers.
    static int countOcc(int num, int [] arr){
        int count = 0;
        for (int i = 0; i<arr.length; i++){
            if(arr[i] == num){
                count++;
            }
        }
        return count;
    }
}
