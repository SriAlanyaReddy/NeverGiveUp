import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort balloons by their end position to optimize the number of arrows
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 0;
        long prevEnd = Long.MIN_VALUE; // Track the position of the last arrow

        for (int[] balloon : points) {
            int currentStart = balloon[0];
            int currentEnd = balloon[1];

            // If the current balloon starts after the last arrow's range, shoot a new arrow
            if (currentStart > prevEnd) {
                arrows++;
                prevEnd = currentEnd; // Update the last arrow's position
            }
        }

        return arrows;
    }
}
