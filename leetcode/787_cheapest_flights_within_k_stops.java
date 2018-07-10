class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final int INF = (int)1e9;
        int[][] dp = new int[2][n];
        // 0 stop
        Arrays.fill(dp[0], INF);
        dp[0][src] = 0;
        for (int[] f : flights) {
            if (f[0] == src) {
                dp[0][f[1]] = f[2];
            }
        }
        // 1,...,K stop
        for (int i = 1; i <= K; i++) {
            int cur = i % 2;
            int prev = (i - 1) % 2;
            // copy from previous array, because it is within k stops, not at k stop
            System.arraycopy(dp[prev], 0, dp[cur], 0, n);
            // iterate flights
            for (int[] f : flights) {
                // 1. if INF is Integer.MAX_VALUE, then this will overflow
                // 2. int Math.min, use dp[cur][f[1]], not dp[prev][f[1]],
                //    because dp[cur][f[1]] may already contains current minimum
                dp[cur][f[1]] = Math.min(dp[cur][f[1]], dp[prev][f[0]] + f[2]);
            }
        }
        return dp[K%2][dst] == INF ? -1 : dp[K%2][dst];
    }
}
