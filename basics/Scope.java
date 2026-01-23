package basics;

public class Scope {
    public static void main(String[] args) {
        int a = 10;
        //int a = 4; //we cannot re-initialize the already initialized variable
        // a = 9; //but we can change the value
        int b = 20;
        String name = "Rahul";
//        swap(a,b);
//        System.out.println(a+" "+b);

        //block scope
        {
             //int a = 8;   //already initialized outside the block in the same method, hence you cannot initialized again.
             //a = 4;   //but you can change the value, re-assign the original ref variable to some other value.
            name = "Kunal";  // you can modify  the original value since no new ref variable is created, original one is used.
            int c = 9;
            //values initialized in this block will remain in this block only , cannot be reused outside this.
        }
        System.out.println(name);
        System.out.println(a);
    }

    //function scope
        static void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
            //this change will only be valid in this function scope only.
       }
}
