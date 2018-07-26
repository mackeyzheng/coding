public class Solution {
    // one array
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

    // rolling array
    public int minPathSum(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;

        int[] cur = new int[N];
        int[] pre = new int[N];
        pre[0] = grid[0][0];
        for (int j = 1; j < N; j++) {
            pre[j] = pre[j-1] + grid[0][j];
        }

        for (int i = 1; i < M; i++) {
            cur[0] = pre[0] + grid[i][0];
            for (int j = 1; j < N; j++) {
                cur[j] = Math.min(pre[j], cur[j-1]) + grid[i][j];
            }
            // swap
            int[] tmp = cur;
            cur = pre;
            pre = tmp;
        }

        return pre[N-1];
    }
}
