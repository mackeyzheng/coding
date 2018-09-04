class Solution {
    // state machine dp - at most 3 * len states (s0, s1, s2 for each price)
    // s0 -- buy --> s1 -- sell --> s2 -- reset (required by cooldown) --> s0
    // s0 and s1 have "reset" pointer to itself
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        final int N = prices.length;
        int[] s0 = new int[N];
        int[] s1 = new int[N];
        int[] s2 = new int[N];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[N - 1], s2[N - 1]);
    }
}
