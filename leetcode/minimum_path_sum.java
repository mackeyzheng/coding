public class Solution {
    public int minPathSum(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;
        int[] status = new int[N];
        Arrays.fill(status, 1, N, Integer.MAX_VALUE); // set status[0] = 0
        for (int i = 0; i < M; i++) {
            status[0] += grid[i][0];
            for (int j = 1; j < N; j++) {
                status[j] = grid[i][j] + Math.min(status[j], status[j-1]);
            }
        }
        return status[N-1];
    }
}
