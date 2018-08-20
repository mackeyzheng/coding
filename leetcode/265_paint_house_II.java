class Solution {
    // time: O(nk)
    // 找出最小和次小的，记录下标
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        final int N = costs.length;
        final int k = costs[0].length;
        int[][] dp = new int[N + 1][k];
        int min1 = -1;
        int min2 = -1;
        for (int i = 1; i <= N; i++) {
            int color1 = min1;
            int color2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != color1) {
                    dp[i][j] = (color1 < 0 ? 0 : dp[i - 1][color1]) + costs[i - 1][j];
                } else {
                    dp[i][j] = (color2 < 0 ? 0 : dp[i - 1][color2]) + costs[i - 1][j];
                }
                if (min1 < 0 || dp[i][min1] > dp[i][j]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || dp[i][min2] > dp[i][j]) {
                    min2 = j;
                }
            }
        }
        return dp[N][min1];
    }
}
