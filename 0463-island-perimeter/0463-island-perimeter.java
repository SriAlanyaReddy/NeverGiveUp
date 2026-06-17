class Solution {

    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == 1) {

                    for (int k = 0; k < 4; k++) {

                        int newRow = row + dr[k];
                        int newCol = col + dc[k];

                        // Boundary crossed
                        if (newRow < 0 || newRow >= rows ||
                            newCol < 0 || newCol >= cols) {

                            perimeter++;
                        }

                        // Water neighbour
                        else if (grid[newRow][newCol] == 0) {

                            perimeter++;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}