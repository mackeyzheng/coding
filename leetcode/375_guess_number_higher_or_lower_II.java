class Solution {
    public int getMoneyAmount(int n) {
        return dfs(1, n, new int[n+1][n+1]);
    }

    private int dfs(int s, int e, int[][] memo) {
        if (s >= e) return 0;
        if (memo[s][e] != 0) return memo[s][e];
        int min = Integer.MAX_VALUE;
        // optimization: instead of iterating from s+1 to e-1, iterate the second half (larger half)
        for (int k = s+(e-s)/2; k < e; k++) {
            // since we don't know whether the chosen k is smaller or higher than the target,
            // choose the worst case (larger cost one)
            int sum = k + Math.max(dfs(s, k-1, memo), dfs(k+1, e, memo));
            // minimize cost among all worst cases (minimax)
            min = Math.min(min, sum);
        }
        memo[s][e] = min;
        return min;
    }
}
