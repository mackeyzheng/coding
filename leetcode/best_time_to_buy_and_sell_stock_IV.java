class Solution {
    // O(nk): state machine dp
    public int maxProfit(int k, int[] prices) {
        // greedy case
        if (k >= prices.length / 2) {
            int ret = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    ret += prices[i] - prices[i - 1];
                }
            }
            return ret;
        }

        // corner case: k == 0
        if (k == 0)
            return 0;

        // state machine
        int[] buy = new int[k]; // buy state
        int[] sell = new int[k]; // sell state
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            // transication 0,...,k-1
            // from start state to buy state 0
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return Math.max(0, sell[k - 1]);
    }

    // O(nk): dp
    public int maxProfit(int k, int[] prices) {
        // greedy case
        if (k >= prices.length / 2) {
            int ret = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    ret += prices[i] - prices[i - 1];
                }
            }
            return ret;
        }

        int[][] dp = new int[prices.length + 1][k + 1];
        for (int kk = 1; kk <= k; kk++) {
            int tmpMax = Integer.MIN_VALUE;
            for (int i = 1; i <= prices.length; i++) {
                dp[i][kk] = Math.max(dp[i - 1][kk], prices[i - 1] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][kk - 1] - prices[i - 1]);
            }
        }
        return dp[prices.length][k];
    }
}
