// Design an algorithm to find the maximum profit. You may complete at most two transactions.
public class Solution {
    // solution1: dp: divide the problem into two parts [0,...,i], [i,...,length-1], find the max profit of those two periods
    // solution2: convert to difference array, and find the max m subarrays, where m = 2 here (two transactions) 
    
    // solution1: dp, use array to record status
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int n = prices.length;
        int[] f = new int[n]; // for transaction 1
        int[] g = new int[n]; // for transaction 2
        // from left to right, calculate status for transaction 1
        for (int i=1, valley=prices[0]; i < n; i++) {
            valley = Math.min(valley, prices[i]);
            f[i] = Math.max(f[i-1], prices[i]-valley); // buy on day valley, sell stock on day i
        }
        // from right to left, calculate status for transaction 2
        for (int j=n-2, peak=prices[n-1]; j >= 0; j--) {
            peak = Math.max(peak, prices[j]);
            g[j] = Math.max(g[j+1], peak-prices[j]);  // buy stock on day j, sell on day peak
        }
        // find the max sum combination
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, f[i]+g[i]);
        }
        return max;
    }
    
    // solution2: use priority queue + remove duplicate updation when add element into queue
}
