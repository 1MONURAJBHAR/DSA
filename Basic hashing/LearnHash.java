import java.util.Scanner;

public class LearnHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        //input array
        System.out.println("Enter array numbers: ");
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        //precomputing frequency (hashing)
        int[] hash = new int[n+1]; //declare the size of hash depending on max length/size of array.
        for (int i = 0; i < n; i++){
            hash[arr[i]]++;
        }

        System.out.println("Enter number of queries: ");
        int q = sc.nextInt();

        while(q-- >0){
            System.out.println("Enter number whose frequency to be searched: ");
            int number = sc.nextInt();
            //fetch frequency

            System.out.println("Frequency of number is: "+hash[number]);
            System.out.println("---------------------------------------");
        }

    }

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the length of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        //Array Input
        System.out.println("Enter array Elements: ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int[] hash = new int[n+1];
        for (int i = 0; i<n; i++){
            hash[arr[i]]++;
        }

        System.out.println("Enter number of queries: ");
        int q = sc.nextInt();

        while(q-- >0){
            System.out.println("Enter element whose occurence to be find: ");

            int num = sc.nextInt();
            int ans = hash[num];

            System.out.println("Frequency is: "+ans);

            System.out.println();
        }

    }*/

}
