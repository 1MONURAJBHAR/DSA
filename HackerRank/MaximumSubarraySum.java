import java.util.List;
import java.util.TreeSet;

public class MaximumSubarraySum {
    public static long maximumSum(List<Long> a, long m) {

        TreeSet<Long> set = new TreeSet<>();

        long prefix = 0;
        long answer = 0;

        for (long x : a) {

            prefix = (prefix + x) % m;

            answer = Math.max(answer, prefix);

            Long higher = set.higher(prefix);

            if (higher != null) {
                answer = Math.max(answer, (prefix - higher + m) % m);
            }

            set.add(prefix);
        }

        return answer;
    }
}
