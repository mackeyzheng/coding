public class Solution {
    // DP: dp(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).
    public int maxProfit(int k, int[] prices) {
        final int N = prices.length;
        if (k >= N/2) return greedy(prices);

        int[][] dp = new int[k+1][N];
        for (int i = 1; i <=k; i++) {
            int max = -prices[0]; // buy on day 0
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + max); // prices[j] + max: sell on day j + previous profit - cost to buy
                max = Math.max(max, dp[i-1][j-1] - prices[j]); // dp[i-1][j-1] - prices[j]: previous profit - buy on day j
            }
        }
        return dp[k][N-1];
    }

    private int greedy(int[] prices) {
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                ret += prices[i] - prices[i-1];
        }
        return ret;
    }
}
