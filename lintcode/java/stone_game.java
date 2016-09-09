public class Solution {
    /**
     * dp + dfs
     *
     * dp[i][j] minimum cost to merge stones from i to j
     * sum[i][j] sum of stones from i to j
     * note: cost to merge one node is 0, dp[i][i] = 0
     *
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) return 0;

        final int N = A.length;
        int[][] dp = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        int[][] sum = new int[N][N];

        // initialize sum
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                sum[i][j] = i == j ? A[j] : sum[i][j-1] + A[j];

        return dfs(0, N-1, dp, visited, sum);
    }

    private int dfs(int p, int q, int[][] dp, boolean[][] visited, int[][] sum) {
        if (visited[p][q]) return dp[p][q];
        
        if (p == q) {
            visited[p][q] = true;
            return dp[p][q];
        }

        dp[p][q] = Integer.MAX_VALUE;
        for (int k = p; k < q; k++)
            dp[p][q] = Math.min(dp[p][q], sum[p][q] + dfs(p, k, dp, visited, sum) + dfs(k+1, q, dp, visited, sum));

        visited[p][q] = true;
        return dp[p][q];
    }
}
