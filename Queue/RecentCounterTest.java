import java.util.LinkedList;
import java.util.Queue;


//LeetCode 933 – Number of Recent Calls
public class RecentCounterTest {

    static class RecentCounter {

        private Queue<Integer> q;

        // Constructor
        public RecentCounter() {
            q = new LinkedList<>();
        }

        // ping function
        public int ping(int t) {
            // Add current request
            q.add(t);

            // Remove outdated requests
            while (!q.isEmpty() && q.peek() < t - 3000) {
                q.remove();
            }

            // Return count of valid requests
            return q.size();
        }
    }

    public static void main(String[] args) {

        RecentCounter rc = new RecentCounter();

        System.out.println(rc.ping(1));     // 1
        System.out.println(rc.ping(100));   // 2
        System.out.println(rc.ping(3001));  // 3
        System.out.println(rc.ping(3002));  // 3
    }
}