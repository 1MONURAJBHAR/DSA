public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    private static void dfs(char[][] grid, int row, int col) {

        // Base Case
        if (row < 0 || col < 0 ||
                row >= grid.length || col >= grid[0].length ||
                grid[row][col] == '0') {
            return;
        }

        // Mark current cell as visited
        grid[row][col] = '0';

        // Visit all four directions
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands: " + numIslands(grid));
    }
}