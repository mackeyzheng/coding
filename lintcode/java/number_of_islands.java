public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        final int M = grid.length;
        if (M == 0) return 0;

        final int N = grid[0].length;
        if (N == 0) return 0;

        int ret = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!grid[i][j]) continue;
                ret++;
                dfs(grid, i, j);
            }
        }

        return ret;
    }

    private void dfs(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;

        if (grid[i][j]) {
            grid[i][j] = false;
            dfs(grid, i-1, j);
            dfs(grid, i+1, j);
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
        }
    }
}
