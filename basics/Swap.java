package basics;

public class Swap {
    /*
      Java = pass by value always
      primitives (int, double) → copy of value
      objects/arrays → copy of reference (but object can be modified)*/

    public static void main(String[] args) {
  //      int a = 10;
  //      int b = 20;

        //swap numbers code
//        int temp = a;
//        a = b;
//        b = temp;

      //  swap(a,b);
        //It’s not swapping because in Java everything is pass-by-value.
        //Java sends copies of a and b into the method, not the original variables.
        //So inside swap() you swap the copies, but the original a and b in main() stay same.
        //for primitive data types it is pass by value, and for complex data structures it is pass by value of reference variable
 //       System.out.println(a+" "+b);

//        String name = "Kunal";
//        changedName(name);
//        System.out.println(name);

       //Because array reference is passed by value, but array object is modified.
        int[] arr = {10, 20};
        swap(arr);

        System.out.println(arr[0] + " " + arr[1]);
    }

//    static void swap(int a, int b){
//        int temp = a;
//        a = b;
//        b = temp;
//    }

//    static void changedName(String name){
//        name = "Monu Rajbhar"; //creates new object, strings cannot be modified they are immutable.
//    }

    static void swap(int[] arr) {
        int temp = arr[0]; //if we make a change to the object via this ref variable, then same object will be changed.
        arr[0] = arr[1];
        arr[1] = temp;
    }


}
