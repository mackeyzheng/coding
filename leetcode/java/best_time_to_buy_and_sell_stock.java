// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock)
// design an algorithm to find the maximum profit.
public class Solution {
    // solution1: find current valley and peak, the peak must on the right side of the valley
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int profit = 0;
        int cur_min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            cur_min = Math.min(cur_min, prices[i]);
            profit = Math.max(profit, prices[i] - cur_min);
        }

        return profit;
    }
    
//     // solution 2: find max sub array of profits
//     public int maxProfit(int[] prices) {
//         if (prices == null || prices.length < 2) return 0;
//         int[] profits = new int[prices.length - 1];
//         for (int i = 0; i < profits.length; i++) {
//             profits[i] = prices[i+1] - prices[i];
//         }
// 
//         int max_ending_here = profits[0];
//         int max_so_far = profits[0];
//         for (int i = 1; i < profits.length; i++) {
//             max_ending_here = Math.max(max_ending_here + profits[i], profits[i]);
//             max_so_far = Math.max(max_so_far, max_ending_here);
//         }
// 
//         return max_so_far > 0 ? max_so_far : 0;
//     }
}
