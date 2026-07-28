public class StaircaseHackerank {
    public static void staircase(int n){
        for(int i = 1; i <= n; i++){

            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            //print #
            for(int j = 1; j <= i; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
