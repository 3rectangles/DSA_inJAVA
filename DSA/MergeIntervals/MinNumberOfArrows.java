package DSA.MergeIntervals;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * ------------------------------------------------
 * You are given an array of balloon intervals [start, end].
 * A balloon with interval [xstart, xend] is burst by shooting an arrow at any x
 * such that xstart <= x <= xend.
 * Arrows move vertically in the positive y-direction from the x-axis, so one arrow
 * can burst multiple balloons if they overlap in x-coordinates.
 *
 * Approach (Greedy):
 * 1. Sort the intervals by their ending point in ascending order.
 * 2. Initialize count = 0, and track the current arrow position.
 * 3. For each balloon:
 *    - If its start is greater than the current arrow position, we need a new arrow.
 *      Set the arrow position to this balloon's end, and increment count.
 *    - Otherwise, the existing arrow at current position bursts this balloon too.
 * 4. Return count.
 *
 * Time Complexity: O(N log N), due to sorting.
 * Space Complexity: O(1) or O(N) depending on sorting implementation.
 */
public class MinNumberOfArrows {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort balloons by their end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1; // We'll need at least one arrow
        int arrowPos = points[0][1]; // Place arrow at the end of first balloon

        // Iterate through all balloons
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];

            // If this balloon starts after the current arrow, we need another arrow
            if (start > arrowPos) {
                count++;
                arrowPos = end; // Move arrow to the end of this balloon
            }
            // Otherwise, it's already burst by the current arrow
        }

        return count;
    }

    // Quick test
    public static void main(String[] args) {
        MinNumberOfArrows solver = new MinNumberOfArrows();

        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(solver.findMinArrowShots(points1)); // Expected: 2

        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(solver.findMinArrowShots(points2)); // Expected: 4
    }
}