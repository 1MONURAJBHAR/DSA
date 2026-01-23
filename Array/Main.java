public class Main {
    public static void main(String[] args) {
        //syntax of array
        //datatype[] variable_name = new datatype[size];
        //store 5 roll numbers;
        //all the type of data in the array should be same;
        // int roll[] = new int[5];
        //or directly
        //int[] roll2 = { 23, 12, 45, 27, 15 };

        int[] ros; //declaration of array. ros is getting defined in the stack, happens at compile time

        //Array objects are in heap.
        //heap objects are, not continuous.
        //Dynamic memory allocation.
        //hence array objects in java may not be continuous, it depends on JVM.
        ros = new int[5];  //initialisation : actually here object is being created in the memory(heap), happens at runtime, memory is allocated at runtime also known as Dynamic memory allocation
    }
}

