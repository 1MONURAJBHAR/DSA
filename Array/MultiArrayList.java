import java.util.ArrayList;
import java.util.Scanner;

public class MultiArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();  //initially it is empty,must initialise it before adding items to it.
        Scanner sc = new Scanner(System.in);

        //Initialization
        for(int i = 0; i<3; i++){
            list.add(new ArrayList<>());
        }

        //add elements
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                list.get(i).add(sc.nextInt());  //get the arraylist at the index i, and add something to it.
            }
        }

        System.out.println(list);
    }
}
