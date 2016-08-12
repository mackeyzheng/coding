public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        final int M = grid.length;
        final int N = grid[0].length;
        int[] f = new int[N];

        f[0] = grid[0][0];
        for (int j = 1; j < N; j++)
            f[j] = grid[0][j] + f[j-1];

        for (int i = 1; i < M; i++) {
            f[0] += grid[i][0];
            for (int j = 1; j < N; j++) {
                f[j] = Math.min(f[j], f[j-1]) + grid[i][j];
            }
        }

        return f[N-1];
    }
}
