import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);
          list.add(11);
          list.add(12);
          list.add(13);
          list.add(14);
          list.add(15);
          list.add(16);
          list.add(17);
          list.add(18);
          list.add(19);
          list.add(20);
       // System.out.println(list.contains(10));
        System.out.println(list);
        //list.set(0,99);  //change value by index
        list.remove(2);  //remove by index
        System.out.println(list);

        //take input using for loop
        for (int i = 0; i<5; i++){
            list.add(sc.nextInt());
        }
        //get item at any index
        for (int i = 0; i<5; i++){
            System.out.println(list.get(i));  //pass index here, list[index] syntax will not work here.
        }

        //or another method, directly print
        //System.out.println(list);
    }
}
