public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int[][] dp = new int[2][3];
        dp[0] = costs[0];
        for (int i = 1; i < costs.length; i++) {
            dp[i%2][0] = Math.min(dp[(i-1)%2][1], dp[(i-1)%2][2]) + costs[i][0];
            dp[i%2][1] = Math.min(dp[(i-1)%2][0], dp[(i-1)%2][2]) + costs[i][1];
            dp[i%2][2] = Math.min(dp[(i-1)%2][0], dp[(i-1)%2][1]) + costs[i][2];
        }

        int pos = (costs.length-1) % 2;
        return Math.min(Math.min(dp[pos][0], dp[pos][1]), dp[pos][2]);
    }
}
