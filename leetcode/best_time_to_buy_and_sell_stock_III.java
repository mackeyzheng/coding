class Solution {
    // state machine and dp
    public int maxProfit(int[] prices) {
        int s1 = Integer.MIN_VALUE;
        int s2 = Integer.MIN_VALUE;
        int s3 = Integer.MIN_VALUE;
        int s4 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }
        return Math.max(0, s4);
    }

    // dp - O(kn), use tmpMax to reduce the third for loop
    // dp[i][k] = max(dp[i-1][k], max(prices[i] - prices[j] + dp[j-1][k-1]))
    //          = max(dp[i-1][k], prices[i] + max(dp[j-1][k-1] - prices[j])) j is in the range of [0,...,i-1]
    public int maxProfit(int[] prices) {
        final int K = 2;
        int[][] dp = new int[prices.length + 1][K + 1];
        for (int k = 1; k <= K; k++) {
            int tmpMax = Integer.MIN_VALUE;
            for (int i = 1; i <= prices.length; i++) {
                dp[i][k] = Math.max(dp[i - 1][k], prices[i - 1] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][k - 1] - prices[i - 1]);
            }
        }
        return dp[prices.length][K];
    }

    // dp - O(kn^2)
    // dp[i][k] = max(dp[i-1][k], max(prices[i] - prices[j] + dp[j-1][k-1]))
    public int maxProfit(int[] prices) {
        final int K = 2;
        int[][] dp = new int[prices.length + 1][K + 1];
        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= prices.length; i++) {
                int tmp = 0;
                for (int j = 1; j < i; j++) {
                    tmp = Math.max(tmp, prices[i - 1] - prices[j - 1] + dp[j - 1][k - 1]);
                }
                dp[i][k] = Math.max(dp[i - 1][k], tmp);
            }
        }
        return dp[prices.length][K];
    }
}
