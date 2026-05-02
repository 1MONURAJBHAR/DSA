public class MinRemoveBrackets {
    public static int minRemovals(String str) {
        int open = 0;     // unmatched '('
        int remove = 0;   // invalid ')'

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                open++;
            } else { // ')'
                if (open > 0) {
                    open--;   // match found
                } else {
                    remove++; // extra ')'
                }
            }
        }

        return remove + open;
    }

    public static void main(String[] args) {
        System.out.println(minRemovals("(()))(")); // 2
        System.out.println(minRemovals("))(("));   // 4
        System.out.println(minRemovals("()()"));   // 0
    }
}