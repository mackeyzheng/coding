class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;

        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(i, j, grid));
            }
        }

        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = -1;

        return 1 + dfs(i + 1, j, grid) + dfs(i - 1, j, grid) + dfs(i, j + 1, grid) + dfs(i, j - 1, grid);
    }
}
