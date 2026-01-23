package basics;

public class reverse {
    public static void main(String[] args) {
        int n = 1234567;

        int reversed = 0;
        while( n > 0 ){
            int rem = n % 10;
            reversed = reversed*10 + rem;
            n = n/10;
        }
        System.out.println(reversed);
    }
}
