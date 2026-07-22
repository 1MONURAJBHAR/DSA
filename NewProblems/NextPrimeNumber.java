public class NextPrimeNumber {

    public static int nextPrime(int n) {
        int num = n + 1;

        while (true) {
            if (isPrime(num)) {
                return num;
            }
            num++;
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(15)); // 17
        System.out.println(nextPrime(7));  // 11
        System.out.println(nextPrime(1));  // 2
    }
}