// time    O(mn)
// space   O(mn)
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        final int M = grid.length;
        final int N = grid[0].length;

        int ret = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ret++;
                }
            }
        }

        return ret;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] != '1')
            return;

        // mark as visited
        grid[i][j] = '2';

        // left
        dfs(grid, i-1, j);
        // right
        dfs(grid, i+1, j);
        // up
        dfs(grid, i, j-1);
        // down
        dfs(grid, i, j+1);
    }
}
