class Solution {
    // Kadane's algorithm - find max sum subarray from the profit array
    public int maxProfit(int[] prices) {
        int maxCur = 0;
        int maxSofar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSofar = Math.max(maxSofar, maxCur);
        }
        return maxSofar;
    }

    // keep left min
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minLeft = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minLeft = Math.min(minLeft, prices[i]);
            profit = Math.max(profit, prices[i] - minLeft);
        }
        return profit;
    }
}
