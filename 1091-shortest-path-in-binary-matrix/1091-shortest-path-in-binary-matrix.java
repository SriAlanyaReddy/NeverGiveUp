import java.util.*;

class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Start or end blocked
        if (grid[0][0] == 1 ||
            grid[n - 1][n - 1] == 1) {

            return -1;
        }

        // Single cell grid
        if (n == 1) {
            return 1;
        }

        // 8 directions
        int[][] directions = {
                {-1,-1}, {-1,0}, {-1,1},
                {0,-1},           {0,1},
                {1,-1},  {1,0},   {1,1}
        };

        boolean[][] visited =
                new boolean[n][n];

        Queue<int[]> queue =
                new LinkedList<>();

        // row, col, distance
        queue.offer(new int[]{0, 0, 1});

        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int distance = current[2];

            // Destination reached
            if (row == n - 1 &&
                col == n - 1) {

                return distance;
            }

            // Visit all 8 neighbours
            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 &&
                    newRow < n &&
                    newCol >= 0 &&
                    newCol < n &&
                    !visited[newRow][newCol] &&
                    grid[newRow][newCol] == 0) {

                    visited[newRow][newCol] = true;

                    queue.offer(
                        new int[]{
                            newRow,
                            newCol,
                            distance + 1
                        }
                    );
                }
            }
        }

        return -1;
    }
}