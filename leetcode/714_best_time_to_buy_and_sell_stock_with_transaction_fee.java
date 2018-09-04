class Solution {
    /*
     * Definition:
     * hold[i] - the maximum profit you can earn if you have to hold at day[i] (1 stock at hand)
     * sold[i] - the maximum profit you can earn if you have to sold at day[i] (0 stock at hand)

     * Formula:
     * hold[i] = max(hold[i - 1], sold[i - 1] - p[i])       // if hold at [i-1], no op; if sold at [i-1], buy at [i] with cost of p[i];
     * sold[i] = max(sold[i - 1], hold[i - 1] + p[i] - fee) // if sold at [i-1], no op; if hold at [i-1], sell at [i] with gain of p[i] - fee;

     * Initialization:
     * hold[0] = 0 - price[0];  // buy shares with cost of p[0];
     * sold[0] = 0;             // no op no cost;
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        final int N = prices.length;
        int[] hold = new int[N];
        int[] sold = new int[N];
        hold[0] = -prices[0];
        for (int i = 1; i < N; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return sold[N - 1];
    }

    // DP - use one varialbe to replace the second dp array
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        final int N = prices.length;
        int[] dp = new int[N];
        int tmp = -prices[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - fee + tmp);
            tmp = Math.max(tmp, dp[i - 1] - prices[i]);
        }
        return dp[N - 1];
    }
}
