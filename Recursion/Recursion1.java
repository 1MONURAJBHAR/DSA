public class Recursion1 {
    public static void main(String[] args) {
        print(0);
    }

    static void print(int count) {
        System.out.println(count);
        count++;

        if (count == 3) return;

        print(count);
    }
}
