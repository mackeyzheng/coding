public class Solution {
    /**
     * dp + dfs
     * time O(mn)  space O(mn)
     * dp(i, j): dp(i, j) is the length of the longest increaing sequence with the end point (i, j)
     *
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;

        final int M = A.length;
        final int N = A[0].length;
        int[][] dp = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        int res = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, dfs(A, i, j, dp, visited));
            }
        }

        return res;
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    private int dfs(int[][] A, int x, int y, int[][] dp, boolean[][] visited) {
        if (visited[x][y])
            return dp[x][y];

        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= A.length || ny < 0 || ny >= A[0].length) continue;
            if (A[nx][ny] >= A[x][y]) continue; // can avoid loop back to previous node in this problem
            dp[x][y] = Math.max(dp[x][y], dfs(A, nx, ny, dp, visited) + 1);
        }

        visited[x][y] = true;
        return dp[x][y];
    }
}
