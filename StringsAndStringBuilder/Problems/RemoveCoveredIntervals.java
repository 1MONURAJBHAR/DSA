import java.util.*;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {

        // Sort by start ascending.
        // If starts are same, sort by end descending.
        /*Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int maxEnd = -1;

        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1];
            }
        }

        return count;*/


        Arrays.sort(intervals, (a,b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int maxEnd = -1;

        for (int[] interval : intervals){
            if (interval[1] > maxEnd){
                count++;
                maxEnd = interval[1];
            }
        }
        return count;
    }

    // Helper method to print intervals
    public static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(Arrays.toString(intervals[i]));
            if (i != intervals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        RemoveCoveredIntervals obj = new RemoveCoveredIntervals();

        // Example 1
        int[][] intervals1 = {
                {1, 4},
                {3, 6},
                {2, 8}
        };

        System.out.println("Example 1");
        System.out.print("Input: ");
        printIntervals(intervals1);
        System.out.println("Remaining Intervals: "
                + obj.removeCoveredIntervals(intervals1));
        System.out.println();

        // Example 2
        int[][] intervals2 = {
                {1, 4},
                {2, 3}
        };

        System.out.println("Example 2");
        System.out.print("Input: ");
        printIntervals(intervals2);
        System.out.println("Remaining Intervals: "
                + obj.removeCoveredIntervals(intervals2));
        System.out.println();

        // Example 3
        int[][] intervals3 = {
                {1, 2},
                {1, 4},
                {3, 4}
        };

        System.out.println("Example 3");
        System.out.print("Input: ");
        printIntervals(intervals3);
        System.out.println("Remaining Intervals: "
                + obj.removeCoveredIntervals(intervals3));
        System.out.println();

        // Example 4
        int[][] intervals4 = {
                {1, 10},
                {2, 5},
                {3, 8},
                {9, 10}
        };

        System.out.println("Example 4");
        System.out.print("Input: ");
        printIntervals(intervals4);
        System.out.println("Remaining Intervals: "
                + obj.removeCoveredIntervals(intervals4));
    }
}