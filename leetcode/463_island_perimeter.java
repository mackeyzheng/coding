class Solution {
    // one-pass: for each 1, add 4 to result first, then evaluate if it has a previous top or left neighbor
    public int islandPerimeter(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;
        int ret = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 1) continue;
                ret += 4;
                if (i - 1 >= 0 && grid[i - 1][j] == 1) ret -= 2;
                if (j - 1 >= 0 && grid[i][j - 1] == 1) ret -= 2;
            }
        }
        return ret;
    }

    // two-pass iterate: calculate top and left first, then right and bottom
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int islandPerimeter(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;
        int[][] cache = new int[M][N];
        // top-left to bottom-right
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 1) continue;
                cache[i][j] = 2;
                for (int k = 0; k <= 1; k++) {
                    int ii = i + dirs[k][0];
                    int jj = j + dirs[k][1];
                    if (ii < 0 || jj < 0 || grid[ii][jj] != 1) continue;
                    cache[i][j]--;
                }
            }
        }

        int ret = 0;
        // bottom-right to top-left
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] != 1) continue;
                cache[i][j] += 2;
                for (int k = 2; k <= 3; k++) {
                    int ii = i + dirs[k][0];
                    int jj = j + dirs[k][1];
                    if (ii >= M || jj >= N || grid[ii][jj] != 1) continue;
                    cache[i][j]--;
                }
                ret += cache[i][j];
            }
        }
        return ret;
    }

    // dfs
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0; // visited
        // grid[i][j] == 1
        // mark as visited
        grid[i][j] = -1;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
