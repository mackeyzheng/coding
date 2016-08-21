public class Solution {
    /**
     * time O(n)  space O(1)
     * dp[i] when there are i coins left, the current player's status is dp[i]
     * dp[i] = !dp[i-1] || !dp[i-2]
     *
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if (n < 1) return false;

        boolean[] dp = new boolean[2];
        dp[0] = true;
        dp[1] = true;
        for (int i = 2; i < n; i++)
            dp[i%2] = !dp[(i-1)%2] || !dp[(i-2)%2];

        return dp[(n-1)%2];
    }
}
