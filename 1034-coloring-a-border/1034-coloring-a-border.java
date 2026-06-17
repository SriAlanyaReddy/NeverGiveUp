import java.util.*;

class Solution {

    List<int[]> borderCells = new ArrayList<>();

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int originalColor = grid[row][col];

        dfs(row, col, originalColor, grid, visited);

        // Color all border cells
        for (int[] cell : borderCells) {
            grid[cell[0]][cell[1]] = color;
        }

        return grid;
    }

    private void dfs(int row,
                     int col,
                     int originalColor,
                     int[][] grid,
                     boolean[][] visited) {

        int rows = grid.length;
        int cols = grid[0].length;

        visited[row][col] = true;

        int[] rowMove = {-1, 1, 0, 0};
        int[] colMove = {0, 0, -1, 1};

        boolean isBorder = false;

        for (int i = 0; i < 4; i++) {

            int newRow = row + rowMove[i];
            int newCol = col + colMove[i];

            // Outside grid
            if (newRow < 0 || newRow >= rows ||
                newCol < 0 || newCol >= cols) {

                isBorder = true;
            }

            // Different color neighbour
            else if (grid[newRow][newCol] != originalColor) {

                isBorder = true;
            }

            // Same color and not visited
            else if (!visited[newRow][newCol]) {

                dfs(newRow, newCol,
                    originalColor,
                    grid,
                    visited);
            }
        }

        // Store border cell
        if (isBorder) {
            borderCells.add(new int[]{row, col});
        }
    }
}