import java.util.Scanner;

public class FindFirstIndexOfElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {6, 7, 8, 4, 1};

        System.out.println("Enter the number: ");
        int input = sc.nextInt();
        int ans = LinearSearch(arr,input);

        if(ans == -1) System.out.println("Number does not exist in the array");
        else System.out.println("First index of number: "+ans);
    }

    static int LinearSearch(int[] arr,int num){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }
}
